package com.fs.app.automation.ScreenshotUtils;

import com.fs.app.automation.DriverUtils.DriverUtils;
import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Map;

public class ScreenshotHook{

    private static final Logger LOG = LoggerFactory.getLogger(ScreenshotHook.class);

    public static void embedScreenshot(Scenario scenario) {
        try {
            Map<String, Object> screenShots = ScreenshotHelper.getScreenShotsForCurrentTest();
            for (Map.Entry<String, Object> screenShot : screenShots.entrySet()) {
                scenario.write(screenShot.getKey());
                scenario.embed((byte[]) screenShot.getValue(), "image/png");
            }

            ScreenshotHelper.tidyUpAfterTestRun();
            byte[] screenShot;
            screenShot = ((TakesScreenshot) DriverUtils.getAppDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenShot, "image/png");

        } catch (WebDriverException | ClassCastException wde) {
            LOG.error(wde.getMessage());
        } finally {
          //DriverUtils.getDriver().switchTo().defaultContent();
        }
    }

    public static void stepScreenshot(String path, String step) {

        try {
            File src = ((TakesScreenshot) DriverUtils.getAppDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(path +"/"+ step + ".png"));

            } catch (WebDriverException | ClassCastException wde) {
        	LOG.error(wde.getMessage());
        }catch (Exception e){
        	LOG.error("Failed to capture screenshot: "+e.getMessage());
        } finally {
           //DriverUtils.getDriver().switchTo().defaultContent();
        }
    }
}
