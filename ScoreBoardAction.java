package com.fs.app.automation.page.action;

import com.fs.app.automation.ActionUtils.ActionUtils;
import com.fs.app.automation.page.object.HomePageObjects;
import com.fs.app.automation.page.object.ScorePageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ScoreBoardAction extends ScorePageObjects {


    public static void clickScoreBtn() {
        ActionUtils.clickBy(HomePageObjects.scoreBoardBtn);
        ActionUtils.takeScreenShot("ScoreBoard");
    }

    public static void selectSport(String sport) {
        //By byDropdownHeader = ScorePageObjects.selectSportDropdown;
        WebElement byDropdownHeader = ActionUtils.findElementBy(ScorePageObjects.selectSportDropdown);
        By byDropdownValue = ScorePageObjects.selectSportFromDropdown;
        String sportToSelect = sport;

        ActionUtils.waitAndClick(byDropdownHeader);
        ActionUtils.selectfromDropdown(byDropdownValue, sportToSelect);
        ActionUtils.takeScreenShot("SportSelection"+sport);

    }

}