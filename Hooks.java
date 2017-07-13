/*
package com.fs.app.automation.step.definition;


import com.xyz.automation.core.Params;
import com.xyz.automation.utils.ExecutionRecord;
import com.xyz.automation.utils.screenshot.ScreenshotHook;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class Hooks {
    private static final Logger LOG = LoggerFactory.getLogger(Hooks.class);
    public static ExecutionRecord record;
    long startTime;

    public static void stepRecordHook(String step){
        if(Params.STEP_RECORD){
            record.stepRecord(step);
        }
    }

    @Before
    public void setUp(Scenario scenario){
        LOG.debug("Before scenario");
        startTime = System.currentTimeMillis();
        record = new ExecutionRecord("./target/screenshots/"+scenario.getName());

    }

    @After
    public void tearDown(Scenario scenario){
        LOG.debug("After scenario");
        long estimatedTime = System.currentTimeMillis() - startTime;
        if(scenario.isFailed()) {
            ScreenshotHook.embedScreenshot(scenario);
            stepRecordHook("FAILED_STEP");        }
            record.closeScenarioRecord(scenario, getDurationBreakdown(estimatedTime));
            record.setTestResults(scenario);
    }

    public static String getDurationBreakdown(long millis) {
        if (millis < 0) {
            throw new IllegalArgumentException("Duration must be greater than zero!");
        }
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis) % 60;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis) % 60;
        return String.format("%d Minutes %d Seconds",minutes, seconds);
    }

}
*/
