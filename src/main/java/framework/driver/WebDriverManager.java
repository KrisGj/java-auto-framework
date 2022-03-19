package framework.driver;

import org.openqa.selenium.WebDriver;

public class WebDriverManager {

    private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    /**
     * Gets the current thread’s instance of the WebDriver.
     *
     * @return the WebDriver instance of the current thread
     */
    public static WebDriver getDriver() {

        return threadLocalDriver.get();
    }

    /**
     * Sets the current thread’s instance of the WebDriver to this browser type.
     *
     * @param driverType the browser type of the WebDriver instance of the current thread
     */
    public static void setWebDriver(WebDriver driverType) {

        threadLocalDriver.set(driverType);
    }

    /**
     * Quits the current thread’s instance of the WebDriver.
     */
    public static void quitDriver() {

        if (WebDriverManager.getDriver() != null) {
            WebDriverManager.getDriver().close();
            WebDriverManager.getDriver().quit();
            threadLocalDriver.remove();
        }
    }
}
