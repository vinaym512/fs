package com.fs.app.automation;

import au.com.foxsports.test.automation.framework.logger.TestFrameworkLogger;
import au.com.foxsports.test.automation.framework.main.ExecutionController;
import au.com.foxsports.test.automation.framework.utilities.helper.Util;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runner.notification.RunListener;

/*
@RunWith(Cucumber.class)
//@CucumberOptions(features = { "classpath:com.fs.app.automation" })
@CucumberOptions(features = { "classpath:src\\main\\resources" })
*/
public class BaseTest extends RunListener {
    // This is dummy BaseTest

    @Override
    public void testRunStarted(Description description) throws Exception {
        TestFrameworkLogger.createTestSuiteLog("Execution started for test suite at " + Util.getCurrentSystemTime("dd/MM/yyyy hh:mm:ss a"));
        //ExecutionController.setupTestSuiteExecution(false);
        //  Configurating report from file:/C:/Users/Vinay.Misra/.m2/repository/com/relevantcodes/extentreports/2.40/extentreports-2.40.jar!/com/relevantcodes/extentreports/resources/extent-config.xml
    }

 /*   *//*
     * (non-Javadoc)
     * @see org.junit.runner.notification.RunListener#testStarted(org.junit.runner.Description)
     *//*
    @Override
    public void testStarted(Description description) throws TestFrameworkException, IOException {
//		ExecutionController.setupTestCaseExecution(description.getMethodName());
    }

    *//*
     * (non-Javadoc)
     * @see org.junit.runner.notification.RunListener#testFinished(org.junit.runner.Description)
     *//*
    @Override
    public void testFinished(Description description) throws Exception {
//		ExecutionController.performTestCaseCompletionTasks();
    }

    *//*
     * (non-Javadoc)
     * @see org.junit.runner.notification.RunListener#testRunFinished(org.junit.runner.Result)
     *//*
    @Override
    public void testRunFinished(Result result) throws TestFrameworkException, IOException {
//		ExecutionController.performTestSuiteCompletionTasks(result);
    }*/
}
