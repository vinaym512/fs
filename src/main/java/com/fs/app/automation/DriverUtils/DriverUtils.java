package com.fs.app.automation.DriverUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverUtils {
	
	private static AppiumDriver driver;

	static {
		try {
			driver = getDriver();
			System.out.println("+++++++++++++++++++++++Driver Started+++++++++++++++++++");

	//		service.start();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public static AppiumDriver getDriver() throws MalformedURLException {
            return getAndroidDriver();
        }

	private static AppiumDriver getAndroidDriver() throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName","Android");
		cap.setCapability("platformVersion","7.0");
		cap.setCapability("deviceName","ce03171312024a3303");
		cap.setCapability("appPackage","com.netcosports.and.foxsports");
		cap.setCapability("appActivity",".activities.InitActivity");
		cap.setCapability("noReset","true");
		cap.setCapability("newCommandTimeout","2");
		cap.setCapability("clearSystemFiles","true");
		return new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);

	}

    private static AppiumDriver getiOSDriver(){
		System.out.println();
		return null;
	}

    public static void closeDriver(){
		driver.quit();


	//stop the appium server
	//	service.stop();
	}


}
