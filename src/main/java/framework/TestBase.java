package framework;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void retryHandler(ITestContext context) {
        for (ITestNGMethod method : context.getAllTestMethods()) {
            method.setRetryAnalyzerClass(Retry.class);
        }
    }

    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        if (System.getenv("HEADLESS").equals("true")) {
            firefoxOptions.addArguments("--headless");
        }
        driver = new FirefoxDriver(firefoxOptions);
        driver.get(System.getenv("BASEURL"));
    }

    public void tearDown() {
        driver.quit();
    }
}
