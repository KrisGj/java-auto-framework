package framework;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    protected WebDriver getDriver() {
        return driver.get();
    }

    @BeforeClass(alwaysRun = true)
    public void retryHandler(ITestContext context) {
        for (ITestNGMethod method : context.getAllTestMethods()) {
            method.setRetryAnalyzerClass(Retry.class);
        }
    }

    @BeforeMethod
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        if (System.getenv("HEADLESS").equals("true")) {
            firefoxOptions.addArguments("--headless");
        }
        driver.set(ThreadGuard.protect(new FirefoxDriver(firefoxOptions)));
        getDriver().get(System.getenv("BASEURL"));
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }
}
