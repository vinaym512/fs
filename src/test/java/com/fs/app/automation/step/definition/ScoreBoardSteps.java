package com.fs.app.automation.step.definition;

import com.fs.app.automation.page.action.ScoreBoardAction;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ScoreBoardSteps {

	@Given("^I click on the score button on top right corner on home page$")
	public static void clickScoreBtn() {
        ScoreBoardAction.clickScoreBtn();
	}
	@Then("^I select \"([^\"]*)\" from dropdown list$")
    public static void selectSport(String sport) {
        try {
            ScoreBoardAction.selectSport(sport);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}