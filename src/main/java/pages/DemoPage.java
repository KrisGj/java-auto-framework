package pages;

import framework.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DemoPage extends BasePage {

    //================================================================================
    // Elements
    //================================================================================

    @FindBy(css = "input#userName")
    private WebElement fullNameField;

    @FindBy(css = "input#userEmail")
    private WebElement emailField;

    @FindBy(css = "textarea#currentAddress")
    private WebElement currentAddressField;

    @FindBy(css = "textarea#permanentAddress")
    private WebElement permanentAddressField;

    @FindBy(css = "button#submit")
    private WebElement submitButton;

    @FindBy(css = "div#output")
    private WebElement outputContainer;

    //================================================================================
    // Constructors
    //================================================================================

    public DemoPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    //================================================================================
    // Methods
    //================================================================================

    /**
     * Navigates to this category in the category list.
     *
     * @param category String representation of the category, for example "Forms"
     */
    public void navigateToCategory(String category) {
        waitForElementToAppearBy(By.xpath("//h5[.='" + category + "']")).click();
    }

    /**
     * Navigates to this subcategory in the category list in the left navigation bar.
     *
     * @param subcategory String representation of the subcategory, for example "Practice Form"
     */
    public void navigateToSubcategory(String subcategory) {
        waitForElementToAppearBy(By.xpath("//span[.='" + subcategory + "']")).click();
    }

    /**
     * Enters this name in the "Full Name" field.
     *
     * @param fullName String representation of the name, for example "Judy Alvarez"
     */
    public void enterFullName(String fullName) {
        waitForElementToAppear(fullNameField).sendKeys(fullName);
    }

    /**
     * Enters this email in the "Email" field.
     *
     * @param email String representation of the email, "jackie.welles@example.com"
     */
    public void enterEmail(String email) {
        waitForElementToAppear(emailField).sendKeys(email);
    }

    /**
     * Enters this address in the "Current Address" text box.
     *
     * @param currentAddress String representation of the address, for example "541 NW Oak Street, Middletown, TX 11251"
     */
    public void enterCurrentAddress(String currentAddress) {
        waitForElementToAppear(currentAddressField).sendKeys(currentAddress);
    }

    /**
     * Enters this address in the "Permanent Address" text box.
     *
     * @param permanentAddress String representation of the address, for example "541 NW Oak Street, Middletown, TX 11251"
     */
    public void enterPermanentAddress(String permanentAddress) {
        waitForElementToAppear(permanentAddressField).sendKeys(permanentAddress);
    }

    /**
     * Taps the "Submit" button.
     */
    public void submitInformation() {
        waitForElementToAppear(submitButton).click();
    }

    /**
     * Gets a String representation of the output that is returned after a set of personal information has been submitted.
     *
     * @return String representation of the output, for example:
     * Name:Johnny Silverhand
     * Email: johnny.silverhand@example.com
     * Current Address :220 W Chicago Avenue, Chicago, IL 60654
     * Permananet Address :1626 Bedford Avenue, Brooklyn, NY 11225
     */
    public String getOutput() {
        List<String> output = new ArrayList<>();
        for (WebElement outputRow : outputContainer.findElements(By.xpath("//p"))) {
            output.add(outputRow.getText());
        }
        return String.join(", ", output);
    }
}
