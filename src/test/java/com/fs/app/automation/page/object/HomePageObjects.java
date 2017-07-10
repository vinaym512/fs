package com.fs.app.automation.page.object;

import org.openqa.selenium.By;

public class HomePageObjects {

	public static By navElementAndroid = By.className("//android.widget.TextView[@text='");
	public static By navElementiPhone = By.className("//XCUIElementTypeStaticText[@name='");
	public static By videoLink = By.xpath("//android.widget.TextView[@text='Video']");
	public static By backArrow = By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']");
	public static By scoreBoardBtn = By.xpath("//android.widget.TextView[@resource-id='com.netcosports.and.foxsports:id/score_center_icon']");


}

