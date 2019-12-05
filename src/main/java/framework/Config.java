package framework;

import io.github.bonigarcia.wdm.FirefoxDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import pageobjects.*;

public class Config {

    private WebDriver driver;

    protected Helpers helpers;
    protected Google google;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {

        System.setProperty("webdriver.gecko.driver", System.getenv("GECKO_PATH"));

        FirefoxDriverManager.firefoxdriver();
        if (System.getenv("HEADLESS").equals("true")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--headless");
            driver = new FirefoxDriver(firefoxOptions);
        } else {
            driver = new FirefoxDriver();
        }

        driver.get(System.getenv("BASEURL"));

        helpers = new Helpers(driver);
        google = new Google(driver);
    }

    @AfterSuite
    public void afterSuite() {

        if (null != driver) {
            driver.quit();
        }
    }
}
