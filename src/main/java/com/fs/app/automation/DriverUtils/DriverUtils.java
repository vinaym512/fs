package com.fs.app.automation.DriverUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverUtils extends EventFiringWebDriver {
	
	private static AppiumDriver driver = null;

	public DriverUtils(WebDriver driver) {
		super(driver);
	}

	/*static {
		try {
			driver = getDriver();
			System.out.println("+++++++++++++++++++++++Driver Started+++++++++++++++++++");

	//		service.start();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}*/

	public static AppiumDriver getDriver() throws MalformedURLException {
		return getAndroidDriver();

        }

	public static AppiumDriver getAndroidDriver() throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName","Android");
		cap.setCapability("platformVersion","7.0");
		cap.setCapability("deviceName","ce03171312024a3303");
		cap.setCapability("appPackage","com.netcosports.and.foxsports");
		cap.setCapability("appActivity",".activities.InitActivity");
		cap.setCapability("noReset","true");
		cap.setCapability("fullReset","false");
		//cap.setCapability("newCommandTimeout","3000");
		cap.setCapability("clearSystemFiles","true");

		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		System.out.println("+++++++++++++++++++++++Driver Started+++++++++++++++++++");

		return driver;

	}

    private static AppiumDriver getiOSDriver(){
		System.out.println();
		return null;
	}

	public static AppiumDriver getAppDriver(){
    	return driver;
	}


    public static void closeDriver() {
		//driver.close();
		try {
			driver.close();
		} catch (NoSuchSessionException e) {
			e.printStackTrace();
		}
	}

	public static void closeNOpenDriver(){
		//driver.close();
		try {
			driver.closeApp();
			driver.launchApp();
		} catch(NoSuchSessionException e){
			e.printStackTrace();
		}


		//stop the appium server
	//	service.stop();
	}


}
