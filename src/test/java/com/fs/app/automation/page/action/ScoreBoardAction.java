package com.fs.app.automation.page.action;

import com.fs.app.automation.ActionUtils.ActionUtils;
import com.fs.app.automation.page.object.HomePageObjects;
import com.fs.app.automation.page.object.ScorePageObjects;
import org.openqa.selenium.By;


public class ScoreBoardAction extends ScorePageObjects {


    public static void clickScoreBtn() {
        ActionUtils.clickBy(HomePageObjects.scoreBoardBtn);
        ActionUtils.takeScreenShot("ScoreBoard");
        System.out.println("++++++++++++++++++Clicked Score Btn+++++++++++++++++++++++");
    }

    public static void selectSport(String sport) throws InterruptedException {
        By byDropdownHeader = ScorePageObjects.selectSportDropdown;
        By byDropdownValue = ScorePageObjects.selectSportFromDropdown;
        String sportToSelect = sport;
        ActionUtils.selectfromDropdown(byDropdownHeader, byDropdownValue, sportToSelect);
        //Thread.sleep(5000);
        ActionUtils.takeScreenShot("SportSelection");
        System.out.println("++++++++++++++++++Sport selected++++++++++++++++++++++++++"+sport);
    }

}