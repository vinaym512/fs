package com.fs.app.automation.page.object;

import org.openqa.selenium.By;

public class ScorePageObjects {

	public static By selectSportDropdown = By.xpath("//android.widget.TextView[@resource-id='com.netcosports.and.foxsports:id/text']");
	public static By selectSportFromDropdown(String sport){
		return By.xpath("//android.widget.TextView[@text='NFL']");
	}



}

