package framework;

import framework.driver.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private static final int TIMEOUT = 5;
    private static final int POLLING_INTERVAL = 100;

    protected final WebDriver driver;

    private final WebDriverWait wait;

    public BasePage() {

        driver = WebDriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT), Duration.ofMillis(POLLING_INTERVAL));
        PageFactory.initElements(driver, this);
    }

    public void waitForPageLoad() {

        ExpectedCondition<Boolean> pageLoadCondition = driver -> driver != null && ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(pageLoadCondition);
    }

    protected WebElement waitForElementToAppear(WebElement element) {

        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement waitForElementToAppearBy(By by) {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void waitForElementToDisappear(WebElement element) {

        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    protected void waitForTextToDisappear(WebElement element, String text) {

        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element, text)));
    }

    protected void dropdownSelectByVisibleText(WebElement element, String text) {

        new Select(element).selectByVisibleText(text);
    }
}
