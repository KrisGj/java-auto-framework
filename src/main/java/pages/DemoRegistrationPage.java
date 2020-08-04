package pages;

import com.github.javafaker.Faker;

import framework.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class DemoRegistrationPage extends BasePage {

    Faker faker = new Faker();

    @FindBy(css = "#btn2")
    private WebElement skipSignInButton;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement lastNameField;

    @FindBy(xpath = "//label[contains(text(),'Address')]/..//textarea")
    private WebElement addressField;

    @FindBy(xpath = "//label[contains(text(),'Email address*')]/..//input")
    private WebElement emailField;

    @FindBy(xpath = "//label[contains(text(),'Phone*')]/..//input")
    private WebElement phoneField;

    @FindBy(css = "#Skills")
    private WebElement skillsDropdown;

    @FindBy(css = "#countries")
    private WebElement countriesDropdown;

    @FindBy(css = "#yearbox")
    private WebElement yearDropdown;

    @FindBy(xpath = "//select[@placeholder='Month']")
    private WebElement monthDropdown;

    @FindBy(css = "#daybox")
    private WebElement dayDropdown;

    @FindBy(css = "#firstpassword")
    private WebElement passwordField;

    @FindBy(css = "#secondpassword")
    private WebElement passwordConfirmationField;

    @FindBy(css = "#submitbtn")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='ui-grid-contents-wrapper']")
    private WebElement usersTable;

    public DemoRegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void navigateToRegistration() {
        skipSignInButton.click();
        waitForPageLoad();
    }

    public void enterFirstAndLastName() {
        firstNameField.sendKeys(faker.name().firstName());
        lastNameField.sendKeys(faker.name().lastName());
    }

    public void enterAddress(String address) {
        addressField.sendKeys(address);
    }

    public void enterEmailAddress() {
        emailField.sendKeys(faker.internet().safeEmailAddress());
    }

    public void enterPhoneNumber() {
        Random random = new Random();
        String firstThree = String.valueOf(random.nextInt(900) + 100);
        String lastFour = String.valueOf(random.nextInt(9000) + 1000);
        phoneField.sendKeys(firstThree + "555" + lastFour);
    }

    public enum Gender {
        MALE,
        FEMALE
    }

    public void selectGender(Gender genders) {
        switch (genders) {
            case MALE -> driver.findElement(By.xpath("//input[@value=\"Male\"]")).click();
            case FEMALE -> driver.findElement(By.xpath("//input[@value=\"FeMale\"]")).click();
        }
    }

    public enum Hobby {
        CRICKET,
        MOVIES,
        HOCKEY
    }

    public void selectHobby(Hobby hobbies) {
        switch (hobbies) {
            case CRICKET -> driver.findElement(By.xpath("//input[@value=\"Cricket\"]")).click();
            case MOVIES -> driver.findElement(By.xpath("//input[@value=\"Movies\"]")).click();
            case HOCKEY -> driver.findElement(By.xpath("//input[@value=\"Hockey\"]")).click();
        }
    }

    public void selectSkill(String skill) {
        dropdownSelectByVisibleText(skillsDropdown, skill);
    }

    public void selectCountry(String country) {
        dropdownSelectByVisibleText(countriesDropdown, country);

    }

    public void enterDateOfBirth(String year, String month, String day) {
        dropdownSelectByVisibleText(yearDropdown, year);
        dropdownSelectByVisibleText(monthDropdown, month);
        dropdownSelectByVisibleText(dayDropdown, day);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
        passwordConfirmationField.sendKeys(password);
    }

    public void submitInformation() {
        submitButton.click();
        waitForPageLoad();
    }

    public boolean isUsersTablePresent() {
        try {
            waitForElementToAppear(usersTable);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
