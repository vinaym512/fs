package com.fs.app.automation.page.action;

import com.fs.app.automation.ActionUtils.ActionUtils;
import com.fs.app.automation.DriverUtils.DriverUtils;
import com.fs.app.automation.page.object.HomePageObjects;
import org.junit.Assert;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;


public class CheckNavigationAction extends HomePageObjects {

    public static void checkIfAppOpen() throws MalformedURLException {
        DriverUtils.openApp();
        Assert.assertTrue(ActionUtils.isElementPresent(HomePageObjects.hamburgerMenu));
    }

    public static void clickVideoLink() throws IOException, InterruptedException, URISyntaxException {
        //Thread.sleep(5000);
        ActionUtils.clickBy(HomePageObjects.videoLink);
        ActionUtils.takeScreenShot("VideoLink");
    }

    public static void clickBackArrow() {
        ActionUtils.clickBy(HomePageObjects.backArrow);
    }

    public static void closeDriver() {
        DriverUtils.quitDriver();
    }

}