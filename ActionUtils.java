package com.fs.app.automation.ActionUtils;

import com.fs.app.automation.DriverUtils.DriverUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.lang.System.getProperty;
import static java.lang.System.nanoTime;

/**
 * Created by vinay.misra on 5/07/2017.
 */
public class ActionUtils {

    private static int positionX = 0;
    private static int positionY = 0;


    public enum Direction {UP, DOWN, LEFT, RIGHT}

    public static Dimension size;
    public static int[] position = new int[2];
    //private static String PLATFORM = getProperty("platform");
    private static RemoteWebDriver driver;

    static {
        driver = DriverUtils.getAppDriver();
    }

    public static void setHorizontalSwipeRatio() {
        size = driver.manage().window().getSize();                                                                        //Get the size of screen.
        position[0] = (int) (size.width * 0.80);                                                                        //Find horizontal point where you wants to swipe. It is in middle of screen width.
        position[1] = (int) (size.width * 0.20);
        //positionX = (int) (size.width * 0.50);
    }

    public static void setVerticalSwipeRatio() {
        size = driver.manage().window().getSize();                                                                        //Get the size of screen.
        position[0] = (int) (size.height * 0.80);
        position[1] = (int) (size.height * 0.20);                                                                          //Find endy point which is at top side of screen.
        //positionY =  (int) (size.height * 0.50);

    }

    public static void swipe(Direction dir, double scrollRatio) {
        try {
            TouchAction ta = new TouchAction((AppiumDriver) driver);
            switch (dir) {
                case LEFT:
                    setHorizontalSwipeRatio();
                    positionY = (int) (size.height * scrollRatio);
                    ta.press(position[0], positionY).waitAction(200).moveTo(position[1], positionY).release().perform();
                    break;
                case UP:
                    setVerticalSwipeRatio();
                    positionX = (int) (size.width * scrollRatio);
                    ta.press(positionX, position[0]).waitAction(200).moveTo(positionX, position[1]).release().perform();
                    break;
                case RIGHT:
                    setHorizontalSwipeRatio();
                    positionY = (int) (size.height * scrollRatio);
                    ta.press(position[1], positionY).waitAction(200).moveTo(position[0], positionY).release().perform();
                    break;
                case DOWN:
                    setVerticalSwipeRatio();
                    positionX = (int) (size.width * scrollRatio);
                    ta.press(positionX, position[1]).waitAction(200).moveTo(positionX, position[0]).release().perform();
                    break;
            }
        } catch (Exception e) {
            System.out.println(":::::: Swipe didn't work ::::::\n" + e.getMessage());
        }
    }

    public static void swipeElement(By by, Direction dir, int scrollAmount) {
        WebElement ele = findElementBy(by);

        int x1 = ele.getLocation().getX();
        int y1 = ele.getLocation().getY();

        if (dir == Direction.LEFT) {
            positionX = x1 - scrollAmount;
            ((AppiumDriver) driver).swipe(x1,y1,positionX,y1,200);
        } else if (dir == Direction.UP) {
            positionY = y1 - scrollAmount;
            ((AppiumDriver) driver).swipe(x1, y1, x1, positionY, 200);
        }
    }

    public static void clickAndWait(AppiumDriver driver, WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.visibilityOf(e));
        if (e.isDisplayed()) {
            e.click();
        }

    }

    public static WebElement findElementBy(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        //goToSleep(2000);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void goToSleep(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clickBy(By by) {
        findElementBy(by).click();
    }

    public static void selectFromDropdown(By byHeader, By byValue, String sportToSelect) {
        findElementBy(byHeader).click();
        if (!clickAnElementFromList(byValue, sportToSelect)) {
            swipe(Direction.UP, 0.50);
            clickAnElementFromList(byValue, sportToSelect);
        }
    }

    public static boolean clickAnElementFromList(By list, String elementText) {
        Boolean elementFound = false;
        List<WebElement> options = driver.findElements(list);
        for (WebElement option : options) {
            if (elementText.equals(option.getText().trim())) {
                option.click();
                elementFound = true;
                break;
            }
        }
        return elementFound;
    }

    public static void tapAnElement(By by) {
        WebElement ele = findElementBy(by);
        // goToSleep(5000);
        new TouchAction((MobileDriver) driver).tap(ele).perform();
    }

    public static void buttonAction(String dir) {
        if (dir.toLowerCase() == "back") {
            ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
        }
    }
}