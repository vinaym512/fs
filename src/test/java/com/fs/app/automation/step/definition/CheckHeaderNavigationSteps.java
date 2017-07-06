package com.fs.app.automation.step.definition;

import com.fs.app.automation.page.action.CheckNavigationAction;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import java.net.MalformedURLException;

public class CheckHeaderNavigationSteps {

	@Given("^I open the FoxSports app on a mobile device$")
	public static void openFoxSportsApp() throws MalformedURLException {
        CheckNavigationAction.openApp();
	}
	@When("^I click on the video tap$")
    public static void clickVideoLink() throws Throwable {
        CheckNavigationAction.clickVideoLink();
        Thread.sleep(5000);
        //CheckNavigationAction.closeDriver();

    }


}