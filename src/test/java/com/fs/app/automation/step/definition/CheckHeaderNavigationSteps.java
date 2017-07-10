package com.fs.app.automation.step.definition;

import com.fs.app.automation.page.action.CheckNavigationAction;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.net.MalformedURLException;

public class CheckHeaderNavigationSteps {

	@Given("^I open the FoxSports app on a mobile device$")
	public static void openFoxSportsApp() throws MalformedURLException {
        CheckNavigationAction.openApp();
	}
	@When("^I click on the video tap and go to the video page$")
    public static void clickVideoLink() throws Throwable {
        CheckNavigationAction.clickVideoLink();
    }
    @Then("^I click on back arrow to come back to previous page$")
    public static void clickBackArrow(){
        CheckNavigationAction.clickBackArrow();
    }
    @And("^I close the driver$")
    public static void closeDriver(){
        CheckNavigationAction.closeDriver();
    }



}