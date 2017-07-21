package com.fs.app.automation.DriverUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverUtils extends EventFiringWebDriver {

	private static RemoteWebDriver driver = null;

	public DriverUtils(WebDriver driver) {
		super(driver);
	}

	static {
			getDriver();
		}

	public static RemoteWebDriver getDriver() {
		return getAndroidDriver();
	}

	public static RemoteWebDriver getAndroidDriver() {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName","Android");
		cap.setCapability("platformVersion","7.0");
		//cap.setCapability("deviceName","6LZ54P5LTSLJMNAE");
		cap.setCapability("deviceName","ce03171312024a3303");
		cap.setCapability("appPackage","com.netcosports.and.foxsports");
		cap.setCapability("appActivity",".activities.InitActivity");
		cap.setCapability("noReset","true");
		cap.setCapability("fullReset","false");
		//cap.setCapability("newCommandTimeout","300");
		cap.setCapability("clearSystemFiles","true");

		try {
			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		System.out.println("+++++++++++++++ "+driver.getSessionId());

		return driver;
	}

	private static AppiumDriver getiOSDriver(){
		System.out.println();
		return null;
	}

	public static RemoteWebDriver getAppDriver(){
		return driver;
	}

	public static void openApp(){
		((AndroidDriver)driver).startActivity("com.netcosports.and.foxsports", ".activities.InitActivity");
	}

	public static void closeApp(){
		((AppiumDriver)driver).closeApp();
	}

	public static void quitDriver() {
		try {
			driver.quit();
		} catch (NoSuchSessionException e) {
			e.printStackTrace();
		}
	}

	public static void closeNOpenDriver(){
		try {
			driver.switchTo().defaultContent();
		} catch(NoSuchSessionException e){
			e.printStackTrace();
		}
	}

}