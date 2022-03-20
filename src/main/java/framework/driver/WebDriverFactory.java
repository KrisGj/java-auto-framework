package framework.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class WebDriverFactory {

    private static final int DEFAULT_WAIT_IN_SECONDS = 30;

    /**
     * Sets the WebDriver to this browser type.
     *
     * @param browser String representation of the browser type, for example "chrome"; String value is case-insensitive
     * @return a WebDriver of the selected browser type
     */
    public static WebDriver getDriver(BrowserType browser) {

        WebDriver driver = switch (browser) {
            case CHROME -> getChrome();
            case FIREFOX -> getFirefox();
        };

        driver.manage().window().fullscreen();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(DEFAULT_WAIT_IN_SECONDS));
        return driver;
    }

    /**
     * Sets up the Firefox WebDriver configuration.
     *
     * @return a Firefox WebDriver object
     */
    private static FirefoxDriver getFirefox() {

        WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("disable-gpu");
        firefoxOptions.addArguments("--start-maximized");
        return new FirefoxDriver(firefoxOptions);
    }

    /**
     * Sets up the Chrome WebDriver configuration.
     *
     * @return a Chrome WebDriver object
     */
    private static ChromeDriver getChrome() {

        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--no-proxy-server");

        if (Boolean.parseBoolean(System.getenv("HEADLESS"))) {
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--window-size=1920,1080");
        }
        return new ChromeDriver(chromeOptions);
    }
}
