package com.fs.app.automation.page.action;

import com.fs.app.automation.ActionUtils.ActionUtils;
import com.fs.app.automation.page.object.HomePageObjects;
import com.fs.app.automation.page.object.ScorePageObjects;


public class ScoreBoardAction extends ScorePageObjects {


    public static void clickScoreBtn() {
        ActionUtils.clickBy(HomePageObjects.scoreBoardBtn);
        ActionUtils.takeScreenShot("ScoreBoard");
        System.out.println("++++++++++++++++++Clicked Score Btn+++++++++++++++++++++++");
    }

    public static void selectSport(String sport) {
        ActionUtils.selectfromDropdown(ScorePageObjects.selectSportDropdown, ScorePageObjects.selectSportFromDropdown(sport), sport);
        ActionUtils.takeScreenShot("SportSelection");
        System.out.println("++++++++++++++++++Sport selected++++++++++++++++++++++++++");
    }

}