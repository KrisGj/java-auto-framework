package pageobjects;

import framework.Helpers;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Google extends Helpers {

    @FindBy(xpath = "//input[@title='Пребарајте']")
    private WebElement searchField;

    @FindBy(xpath = "//div[@id='topabar']")
    private WebElement searchResultsPageHeader;

    public Google(WebDriver driver) {
        super(driver);
    }

    public void enterAndSubmitSearch(String query) {
        this.waitForElementToAppear(searchField);
        searchField.sendKeys(query);
        searchField.sendKeys(Keys.ENTER);
        this.waitForElementToAppear(searchResultsPageHeader);
    }
}