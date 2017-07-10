package com.fs.app.automation.page.action;

import com.fs.app.automation.ActionUtils.ActionUtils;
import com.fs.app.automation.DriverUtils.DriverUtils;
import com.fs.app.automation.page.object.HomePageObjects;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;


public class CheckNavigationAction extends HomePageObjects {


    public static void openApp() throws MalformedURLException {
        DriverUtils.getDriver();
    }

    public static void clickVideoLink() throws IOException, InterruptedException, URISyntaxException {
        //Thread.sleep(5000);
        ActionUtils.clickBy(HomePageObjects.videoLink);
        ActionUtils.takeScreenShot("VideoLink");
        System.out.println("++++++++++++++++++Clicked Video Link+++++++++++++++++++++++");
    }

    public static void clickBackArrow() {
        ActionUtils.clickBy(HomePageObjects.backArrow);
        System.out.println("++++++++++++++++++Back arrow clicked+++++++++++++++++++++++");
    }

    public static void closeDriver() {
        DriverUtils.closeDriver();
        System.out.println("++++++++++++++++++Close driver+++++++++++++++++++++++++++++");
    }

}