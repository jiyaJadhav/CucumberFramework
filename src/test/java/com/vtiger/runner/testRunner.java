package com.vtiger.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(

        features = "src/test/resources/Features",

        glue = {"com.vtiger.stepdefinations"},

        plugin = {
                "pretty",
                "html:target/cucumber-reports/report.html",
                "json:target/cucumber-reports/report.json",
                "junit:target/cucumber-reports/report.xml"
        },

        monochrome = true,
        dryRun = false,
        publish = true
)

public class testRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {

        return super.scenarios();
    }
}