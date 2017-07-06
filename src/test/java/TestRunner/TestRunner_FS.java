package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
		features = "src\\main\\resources"
		,glue = { "com.fs.app.automation.step.definition" }
		,tags = {"@Nav"}
		)


public class TestRunner_FS {

	/*@BeforeClass
	public static void initialise() {
		System.setProperty("PLATFORM", "Android");
	}
	*/
	/*@AfterClass
	public static void close() {
		DriverUtils.closeDriver();



		AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
		service.start();
//your test scripts logic...
		service.stop();
	}*/
} 