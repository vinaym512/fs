package com.fs.app.automation.ScreenshotUtils;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public class EmailReporter {
    private static final Logger LOG = LoggerFactory.getLogger(EmailReporter.class);
    private static FileWriter fWriter;
    private static BufferedWriter writer;
    private static File indexFile;

    private static int totalTc;
    private static int totalPTc;
    private static int totalFTc;
    private static int totalITc;

    private static String getTestHTML(File dir)throws Throwable{
        String content = null;
        File[] listOfFiles = dir.listFiles();
        for (File ifile : listOfFiles) {
            if (ifile.isFile() && ifile.getName().equals("temp.html")) {
                content = FileUtils.readFileToString(ifile,"UTF-8");
                ifile.delete();
                return content;
            }
        }
        return null;
    }

    //public static void main(String[] args) throws Throwable {
    public static void reportMail(String args) throws Throwable {
        //String path = args[0];
        String path = args;
        setTestResultTable(path);
        File reportDirectory = new File(path);
        if (reportDirectory.exists()) {
            try {
                indexFile = new File(reportDirectory + "/index.html");
                if(!indexFile.exists()){
                    writeFirstRecordWithHeader(reportDirectory,path);

                }else {
                   writeNextRecord(reportDirectory, path);
                }
            } catch (Exception e) {
                LOG.error("Error while writing the file" + e.getMessage());
            }
        }
    }

    private static void setTestResultTable(String path)throws Throwable{
        File reportDirectory = new File(path);
        File[] files = new File(path).listFiles();
        if(files== null || files.length==0 ){
            return;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                readFileAndSetGlobalVariables(file);
            }
        }

        if (reportDirectory.exists()) {
            try {
                fWriter = new FileWriter(reportDirectory+"/FinalFile.html");
                writer = new BufferedWriter(fWriter);
                writer.write("<html>\n" +
                        "<head>\n" +
                        "<title>Execution Summary</title>\n" +
                        "</head>" +
                        "<body>" +
                        "<table border='1' width='400'>\n" +
                        "<tr>\n " +
                        "<th bgcolor='#0099CC'><font color='white'>Total Test Case</font></th>\n" +
                        "<th bgcolor='#04B431'><font color='white'>Pass</font></th>\n" +
                        "<th bgcolor='#DF3A01'><font color='white'>Fail</font></th>\n" +
                        "<th bgcolor='#e6e600'><font color='white'>Skip</font></th>\n" +
                        "</tr>");
                writer.write(
                        "<tr >\n " +
                                "<th class = 'tc'>"+totalTc+"</th>\n" +
                                "<th class = 'ptc'>"+totalPTc+"</th>\n" +
                                "<th class = 'ftc'>"+totalFTc+"</th>\n" +
                                "<th class = 'itc'>"+totalITc+"</th>\n" +
                                "</tr>"
                );

                writer.write("</table>\n" +
                        "</body>\n" +
                        "</html>");

                writer.close();
                fWriter.close();
            } catch (Exception e) {
                LOG.error("Error while writing the file");
            }
        }
    }


    private static void readFileAndSetGlobalVariables(File dir)throws Throwable{
        String content = null;
        File[] listOfFiles = dir.listFiles();
        //System.out.println("TotalNumber Of Files " + listOfFiles.length );
        for (File ifile : listOfFiles) {
            if (ifile.isFile() && ifile.getName().endsWith(".txt")) {
                content = FileUtils.readFileToString(ifile, "UTF-8");
                String[] splitData = content.split(",");
                totalTc += Integer.parseInt(splitData[0]);
                totalPTc += Integer.parseInt(splitData[1]);
                totalFTc += Integer.parseInt(splitData[2]);
                totalITc += Integer.parseInt(splitData[3]);
                ifile.delete();
            }
        }
    }

    private static void writeFirstRecordWithHeader(File reportDirectory, String path) throws Throwable {
        fWriter = new FileWriter(reportDirectory + "/index.html");
        writer = new BufferedWriter(fWriter);
        writer.write("<html>\n" +
                "<head>\n" +
                "<title>Execution Summary</title>\n" +
                "</head>" +
                "<body>" +
                "<table border=\"1\">\n" +
                "<tr bgcolor='#989898'>\n " +
                "<th><font color='white'>Scenario</font></th>\n" +
                "<th><font color='white'>Result</font></th>\n" +
                "<th><font color='white'>Time Taken</font></th>\n" +
                "</tr>");
        File[] files = new File(path).listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                writer.write(getTestHTML(file));
            }
        }
        writer.write("</table>\n" +
                "</body>\n" +
                "</html>");

        writer.close();
        fWriter.close();
    }
    private static void writeNextRecord(File reportDirectory, String path ) throws Throwable {
        fWriter = new FileWriter(reportDirectory + "/index.html",true);
        writer = new BufferedWriter(fWriter);
        writer.write("<html>\n" +
                "<body>" +
                "<table border=\"1\">\n" +
                "<tr bgcolor='#989898'>\n " +
                "</tr>");
        File[] files = new File(path).listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                String html = getTestHTML(file);
                if(html != null)
                    writer.write(html);
            }
        }
        writer.write("</table>\n" +
                "</body>\n" +
                "</html>");

        writer.close();
        fWriter.close();
    }

}