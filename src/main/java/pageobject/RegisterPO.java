package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

import java.util.List;

public class RegisterPO {

    WebDriver driver;
    SeleniumHelpers selenium;

    public RegisterPO(WebDriver driver) {
        this.driver = driver;
        this.selenium = new SeleniumHelpers(driver);

        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    /*
     * All WebElements are identified by @FindBy annotation
     *
     * @FindBy can accept tagName, partialLinkText, name, linkText, id, css,
     * className, xpath as attributes.
     */

    @FindBy(id = "input-:R36l6:")
    private WebElement nameInputText;

    @FindBy(id = "input-:R156l6:")
    private WebElement phoneNumInputText;

    @FindBy(id = "input-:R76l6:")
    private WebElement businessNameInputText;


    @FindBy(xpath = "//input[@name='businessType']/following-sibling::label")
    private List<WebElement> businessTypeRadioBtn;


    @FindBy(id = "input-:Rb6l6:")
    private WebElement emailInputText;

    @FindBy(id = "input-:Rd6l6:")
    private WebElement passwordInputText;

    @FindBy(id = "input-:Rf6l6:")
    private WebElement confirmPasswordInputText;

    @FindBy(id = "register__checkbox__tnc")
    private WebElement registerCheckbox;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement registerButton;

    @FindBy(xpath = "//p[@role='alert']")
    private WebElement errorMessage;

    @FindBy(xpath = "//p[@data-testid='register__text-field__name__error']")
    private WebElement nameFieldError;

    @FindBy(xpath = "//button[@data-testid='register__icon__eye-password']")
    private WebElement eyeIcon;


    /**
     * Enters the provided name into the name input field.
     * @param name The name to be entered into the input field.
     */
    public void enterName(String name) {
        selenium.enterText(nameInputText, name, true);
    }

    /**
     * Enters the provided phone number into the phone number input field.
     * @param phoneNum The phone number to be entered into the input field.
     */
    public void enterPhoneNum(String phoneNum) {
        selenium.enterText(phoneNumInputText, phoneNum, true);
    }

    /**
     * Enters the provided business name into the business name input field.
     * @param businessName The business name to be entered into the input field.
     */
    public void enterBusinessName(String businessName) {
        selenium.enterText(businessNameInputText, businessName, true);
    }

    /**
     * Selects the provided business type.
     * @param businessType The business type to be selected.
     */
    public void selectBusinessType(String businessType) {
        for (WebElement radioButton : businessTypeRadioBtn) {
            if (radioButton.getText().equals(businessType)) {
                radioButton.click();
                return ;
            }
        }
        throw new IllegalArgumentException("Radio button not found for business type: " + businessType);
    }


    /**
     * Enters the provided email into the email input field.
     * @param email The email to be entered into the input field.
     */
    public void enterEmail(String email) {
        selenium.enterText(emailInputText, email, true);
    }

    /**
     * Enters the provided password into the password input field.
     * @param password The password to be entered into the input field.
     */
    public void enterPassword(String password) {
        selenium.enterText(passwordInputText, password, true);
    }

    /**
     * Enters the provided confirm password into the confirmation password input field.
     * @param confirmPassword The confirmation password to be entered into the input field.
     */
    public void enterConfirmPassword(String confirmPassword) {
        selenium.enterText(confirmPasswordInputText, confirmPassword, true);
    }

    /**
     * Clicks on the register checkbox.
     */
    public void clickOnRegisterCheckbox() throws InterruptedException {
        selenium.clickOn(registerCheckbox);
    }

    /**
     * Clicks on the register button.
     */
    public void clickOnRegisterButton() throws InterruptedException {
        selenium.clickOn(registerButton);
    }

    /**
     * Retrieves the error message displayed on the page.
     * @return The error message displayed on the page.
     */
    public String getErrorMessage() {
        return selenium.getText(errorMessage);
    }

    /**
     * Retrieves the error message displayed on the name field.
     * @return The error message displayed on the name field.
     */
    public String getNameFieldError() {
        return selenium.getText(nameFieldError);
        }

    /**
     * Clicks on the eye icon to show the password.
     */
    public void clickOnEyeIcon() throws InterruptedException {
        selenium.clickOn(eyeIcon);
    }

    public String getErrorAlert() {
        return selenium.getAlertText();
    }


}
