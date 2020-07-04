package framework;

import io.github.bonigarcia.wdm.FirefoxDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Config {

    protected WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void retryHandler(ITestContext context) {
        for (ITestNGMethod method : context.getAllTestMethods()) {
            method.setRetryAnalyzerClass(Retry.class);
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", System.getenv("GECKOWEBDRIVER"));
        FirefoxDriverManager.firefoxdriver();
        if (System.getenv("HEADLESS").equals("true")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--headless");
            driver = new FirefoxDriver(firefoxOptions);
        } else {
            driver = new FirefoxDriver();
        }
        driver.get(System.getenv("BASEURL"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}
