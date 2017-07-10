package com.fs.app.automation.ActionUtils;

import com.fs.app.automation.DriverUtils.DriverUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static java.lang.System.getProperty;

/**
 * Created by vinay.misra on 5/07/2017.
 */
public class ActionUtils {

    private static int positionX = 0;
    private static int positionY = 0;


    public enum Direction {UP, DOWN, LEFT, RIGHT}
    public static Dimension size;
    public static int[] position = new int[2];
    private static String PLATFORM = getProperty("platform");
    private static AppiumDriver driver;

    static {
        driver = DriverUtils.getAppDriver();
    }

    public static void setHorizontalSwipeRatio(AppiumDriver driver) throws InterruptedException {
        size = driver.manage().window().getSize();																		//Get the size of screen.
        position[0] = (int) (size.width * 0.70);																		//Find horizontal point where you wants to swipe. It is in middle of screen width.
        position[1] = (int) (size.width * 0.20);
    }

    public static void setVerticalSwipeRatio(AppiumDriver driver) throws InterruptedException {
        size = driver.manage().window().getSize();																		//Get the size of screen.
        position[0] = (int) (size.height * 0.65);
        position[1] = (int) (size.height * 0.40);																		//Find endy point which is at top side of screen.
    }

    public static void swipe(AppiumDriver driver, Direction dir, double scrollRatio) throws InterruptedException {
        try {
            TouchAction ta = new TouchAction(driver);
            switch(dir) {
                case LEFT:
                    positionY = (int) (size.height * scrollRatio);
                    ta.press(position[0], positionY).waitAction(200).moveTo(position[1], positionY).release().perform();
                    break;
                case DOWN:
                    positionX = (int) (size.width * scrollRatio);
                    ta.press(positionX, position[0]).waitAction(200).moveTo(positionX, position[1]).release().perform();
                    break;
                case RIGHT:
                    positionY = (int) (size.height * scrollRatio);
                    ta.press(position[1], positionY).waitAction(200).moveTo(position[0], positionY).release().perform();
                    break;
                case UP:
                    positionX = (int) (size.width * scrollRatio);
                    ta.press(positionX, position[1]).waitAction(200).moveTo(positionX, position[0]).release().perform();
                    break;
            }
        }
        catch(Exception e){
            System.out.println("touch failing on server with message " +e.getMessage());
        }
    }

    public static void clickAndWait(AppiumDriver driver, WebElement e)  {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.visibilityOf(e));
        if (e.isDisplayed()){
            e.click();
        }

    }

    public static WebElement findElementBy(By by){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void clickBy(By by){
        findElementBy(by).click();
    }

    public static void selectfromDropdown(By by, By by2, String sport) {
        /*Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByVisibleText(visibleText);*/

        /*WebElement dropdown = findElementBy(by);
        dropdown.sendKeys(visibleText);
        */

        WebElement select = findElementBy(by);
        List<WebElement> options = select.findElements(by2);

        for (WebElement option : options) {

            if(sport.equals(option.getText().trim()))

                option.click();
        }

    }


    public static void takeScreenShot(String element) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File("target/screenshots/page" + element + ".png"));
        } catch (IOException e) {
            System.out.println("Screenshot error " + e.getMessage());
        }
    }
}
