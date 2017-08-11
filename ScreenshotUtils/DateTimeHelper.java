package com.fs.app.automation.ScreenshotUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by vinay on 23/07/2017.
 */
public class DateTimeHelper {

    public static String getCurrenDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy");
        LocalDate localDate = LocalDate.now();
        String date = dtf.format(localDate);
        return date;
    }
}
