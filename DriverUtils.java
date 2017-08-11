package com.fs.app.automation.DriverUtils;

import com.fs.app.automation.Misc.Params;
import com.fs.app.automation.Misc.Props;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverUtils extends EventFiringWebDriver {
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(DriverUtils.class);
	static String platfrm;


    private static RemoteWebDriver driver = null;
	public DriverUtils(WebDriver driver) {
		super(driver);
	}

	private static final Thread CLOSE_THREAD = new Thread() {
        @Override
        public void run() {
            closeDriver();
        }
    };

	static {
		   	Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
			Props.loadRunConfigProps();
		platfrm = Params.PLATFORM;

			getDriver();
		//getAndroidDriver2();
	}


	public static RemoteWebDriver getDriver() {

		//if(Params.PLATFORM.toLowerCase().equals("android")) {
		if(platfrm.toLowerCase().equals("android")) {
			return getAndroidDriver();
		}
		else{
			return getiOSDriver();
		}
	}

	public static RemoteWebDriver getAndroidDriver() {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName","Android");
		//cap.setCapability("platformVersion","7.0");
		//cap.setCapability("deviceName","ZX1G42BQHB");
		cap.setCapability("udid","ZX1G42BQHB");

		cap.setCapability("deviceName","Android");
		cap.setCapability("applicationName","Nexus");
        //cap.setCapability("deviceName","ce03171312024a3303");applicationName
        cap.setCapability("appPackage","com.netcosports.and.foxsports");
		cap.setCapability("appActivity",".activities.InitActivity");
		cap.setCapability("noReset","true");
		cap.setCapability("fullReset","false");
		cap.setCapability("newCommandTimeout","30000");
		cap.setCapability("clearSystemFiles","true");
		cap.setCapability("unlockType", "pin");
		cap.setCapability("unlockKey" , "0000");

		try {
			//driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
			driver = new AndroidDriver(new URL("http://10.22.141.174:4723/wd/hub"), cap);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}

	public static RemoteWebDriver getAndroidDriver2() {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName","Android");
		cap.setCapability("deviceName","Android");
		cap.setCapability("applicationName","Samsung S8");
		cap.setCapability("udid","ce03171312024a3303");
		cap.setCapability("appPackage","com.netcosports.and.foxsports");
		cap.setCapability("appActivity",".activities.InitActivity");
		cap.setCapability("noReset","true");
		cap.setCapability("fullReset","false");
		cap.setCapability("newCommandTimeout","30000");
		cap.setCapability("clearSystemFiles","true");
		cap.setCapability("unlockType", "pin");
		cap.setCapability("unlockKey" , "0000");

		try {
			//driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
			driver = new AndroidDriver(new URL("http://10.22.141.174:4725/wd/hub"), cap);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}

    private static AppiumDriver getiOSDriver(){
		System.out.println();
		return null;
	}

	public static RemoteWebDriver getAppDriver(){
    	return driver;
	}

    public static void closeDriver() {
		try{
            driver.quit();
        } catch (NoSuchSessionException e) {
            LOG.info("The driver is already closed!!");
        }
	}

    @Override
    public void close() {
        if (Thread.currentThread() != CLOSE_THREAD) {
            throw new UnsupportedOperationException(
                    "Do not close this WebDriver. It's shared and will close when the JVM exits.");
        }
        super.close();
    }

    public static void reOpenApp(){
		try {
		((AndroidDriver)driver).startActivity("com.netcosports.and.foxsports",".activities.InitActivity");
		}catch (Exception e){
			LOG.error(e.getMessage());
		}
	}

	public static void closeNOpenDriver(){
		try {
			driver.switchTo().frame(1);
            //driver.switchTo().defaultContent();
			//driver.resetInputState();
		} catch(NoSuchSessionException e){
			e.printStackTrace();
		}
	}
}
