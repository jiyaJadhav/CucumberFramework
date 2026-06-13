package com.vtiger.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class commonMethods {

    public static WebDriver driver;
    public static Properties prop;
    public static WebDriverWait wait;

    public static void launchBrowser() throws IOException {

        prop = new Properties();

        FileInputStream fis =
                new FileInputStream("src/test/resources/config.properties");

        prop.load(fis);
        fis.close();

        String browser =
                prop.getProperty("browser").trim().toLowerCase();

        switch (browser) {

            case "chrome":

                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":

                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "edge":

                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:

                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }

        int globalWait =
                Integer.parseInt(prop.getProperty("globalwait"));

        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(globalWait));

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(globalWait));

        driver.get(prop.getProperty("appurl"));
    }

    public static void closeBrowser() {

        if (driver != null) {

            driver.quit();
            driver = null;
        }
    }

    public static WebElement waitForElement(By locator) {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickable(By locator) {

        return wait.until(
                ExpectedConditions.elementToBeClickable(locator));
    }

    public static String takeScreenshot(String testName) {

        try {

            String timestamp =
                    new SimpleDateFormat("yyyyMMdd_HHmmss")
                            .format(new Date());

            String path = "./screenshots/";

            new File(path).mkdirs();

            String filePath =
                    path + testName + "_" + timestamp + ".png";

            File src =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.FILE);

            File dest = new File(filePath);

            java.nio.file.Files.copy(
                    src.toPath(),
                    dest.toPath(),
                    StandardCopyOption.REPLACE_EXISTING);

            return filePath;

        } catch (Exception e) {

            return null;
        }
    }

    public static String takeScreenshotBase64() {

        return ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BASE64);
    }

    public static void jsClick(WebElement element) {

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", element);
    }

    public static void scrollToElement(WebElement element) {

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static String getProperty(String key) {

        return prop.getProperty(key);
    }
}