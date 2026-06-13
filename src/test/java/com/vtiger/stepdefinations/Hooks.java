package com.vtiger.stepdefinations;

import com.vtiger.utilities.commonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends commonMethods {

    @Before
    public void setUp(Scenario scenario) throws Exception {

        System.out.println("========================================");
        System.out.println("Starting Scenario : " + scenario.getName());
        System.out.println("========================================");

        launchBrowser();
    }

    @After
    public void tearDown(Scenario scenario) {

        System.out.println("Scenario Status : " + scenario.getStatus());

        if (scenario.isFailed() && driver != null) {

            try {

                byte[] screenshot =
                        ((TakesScreenshot) driver)
                                .getScreenshotAs(OutputType.BYTES);

                scenario.attach(
                        screenshot,
                        "image/png",
                        scenario.getName());

            } catch (Exception e) {

                System.out.println("Screenshot Failed");
            }
        }

        closeBrowser();
    }
}