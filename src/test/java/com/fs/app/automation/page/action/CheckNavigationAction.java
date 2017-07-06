package com.fs.app.automation.page.action;

import com.fs.app.automation.ActionUtils.ActionUtils;
import com.fs.app.automation.DriverUtils.DriverUtils;
import com.fs.app.automation.page.object.PageObjects;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;


public class CheckNavigationAction extends DriverUtils{


    public static void openApp() throws MalformedURLException {
        getDriver();
    }

    public static void clickVideoLink() throws IOException, InterruptedException, URISyntaxException {
        ActionUtils.clickBy(PageObjects.videoLink);
        ActionUtils.takeScreenShot("VideoLink");
        Thread.sleep(5000);
        System.out.println("++++++++++++++++++Clicked Video Link+++++++++++++++++++++++");
    }

    public static void closeDriver() {
        DriverUtils.closeDriver();
        System.out.println("++++++++++++++++++Close driver+++++++++++++++++++++++++++++");
    }
}