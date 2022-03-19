package framework;

import framework.driver.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    /**
     * Starts an instance of this browser type.
     *
     * @param browser the type of browser instance to start; defaults to "chrome" if not provided in TestNG XML
     */
    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {

        WebDriverManager.setWebDriver(WebDriverFactory.getDriver(BrowserType.fromValue(browser)));
    }

    /**
     * Quits the instance of the currently running browser type.
     */
    @AfterMethod
    public void tearDown() {

        WebDriverManager.quitDriver();
    }
}
