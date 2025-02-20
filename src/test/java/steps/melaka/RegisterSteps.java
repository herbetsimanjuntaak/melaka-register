package steps.melaka;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobject.RegisterPO;
import utilities.JavaHelper;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

public class RegisterSteps {

    private final WebDriver driver = ThreadManager.getDriver();
    private final RegisterPO register = new RegisterPO(driver);
    private final SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @Given("user access page {string}")
    public void user_access_page(String url) throws InterruptedException {
        selenium.navigateToPage(url);
    }

    @When("user input name {string}")
    public void userInputName(String username) {
        register.enterName(username);
    }

    @And("user input phone number {string}")
    public void userInputPhoneNumber(String phoneNumber) {
        register.enterPhoneNum(phoneNumber);
    }

    @And("user input business name {string}")
    public void userInputBusinessName(String businessName) {
        register.enterBusinessName(businessName);
    }

    @And("user selects {string}")
    public void userSelectsFrom(String businessType) {
        register.selectBusinessType(businessType);
    }

    @And("user input email {string}")
    public void userInputEmail(String email) {
        register.enterEmail(email);
    }

    @When("user input password {string}")
    public void user_input_password(String password) throws InterruptedException {
        register.enterPassword(password);
        register.clickOnEyeIcon();
    }

    @And("user input confirm password {string}")
    public void userInputConfirmPassword(String confirmPassword) throws InterruptedException {
        register.enterConfirmPassword(confirmPassword);
        register.clickOnEyeIcon();
    }

    @And("user click on checkbox register")
    public void userClickOnCheckboxRegister() throws InterruptedException {
        register.clickOnRegisterCheckbox();
    }

    @And("user click on button register")
    public void userClickOnButtonRegister() throws InterruptedException {
        register.clickOnRegisterButton();
    }

    @Then("system display Selamat datang di Melaka")
    public void systemDisplaySelamatDatangDiMelaka() throws InterruptedException {
        Thread.sleep(1000);
    }


    @Then("system display error message {string}")
    public void systemDisplayErrorMessage(String errorMessage) {
        String actualErrorMessage = register.getErrorMessage();
        Assert.assertTrue(actualErrorMessage.contains(errorMessage), "Error message is " + actualErrorMessage);
    }

    @Then("system display error name field message {string}")
    public void systemDisplayErrorNameFieldMessage(String errorMessage) {
        String actualErrorMessage = register.getNameFieldError();
        Assert.assertTrue(actualErrorMessage.contains(errorMessage), "Error message is not displayed");
    }

    @And("user has completed the other fields and click button register")
    public void userHasCompletedTheOtherFieldsAndClickButtonRegister() throws InterruptedException {
        register.enterPhoneNum(JavaHelper.generateRandomPhoneNumber());
        register.enterBusinessName(JavaHelper.generateRandomJob());
        register.selectBusinessType("Brand");
        register.enterEmail(JavaHelper.generateRandomEmail());
        String password = JavaHelper.generateRandomPassword();
        register.enterPassword(password);
        register.enterConfirmPassword(password);
        register.clickOnRegisterCheckbox();
        register.clickOnRegisterButton();
    }

    @And("user has completed the other fields")
    public void userHasCompletedTheOtherFields() {
        register.enterName(JavaHelper.generateRandomName());
        register.enterBusinessName(JavaHelper.generateRandomJob());
        register.selectBusinessType("Brand");
        register.enterEmail(JavaHelper.generateRandomEmail());
        String password = JavaHelper.generateRandomPassword();
        register.enterPassword(password);
        register.enterConfirmPassword(password);
    }

    @And("user click on checkbox register and button register")
    public void userClickOnCheckboxRegisterAndButtonRegister() throws InterruptedException {
        register.clickOnRegisterCheckbox();
        register.clickOnRegisterButton();
    }


    @And("user are completed all fields except business name")
    public void userAreCompletedAllFieldsExceptBusinessName() {
        register.enterName(JavaHelper.generateRandomName());
        register.enterPhoneNum(JavaHelper.generateRandomPhoneNumber());
        register.selectBusinessType("Penjual Online");
        register.enterEmail(JavaHelper.generateRandomEmail());
        String password = JavaHelper.generateRandomPassword();
        register.enterPassword(password);
        register.enterConfirmPassword(password);
    }

    @And("user are completed all fields except email")
    public void userAreCompletedAllFieldsExceptEmail() {
        register.enterName(JavaHelper.generateRandomName());
        register.enterPhoneNum(JavaHelper.generateRandomPhoneNumber());
        register.enterBusinessName(JavaHelper.generateRandomJob());
        register.selectBusinessType("Toko Retail");
        String password = JavaHelper.generateRandomPassword();
        register.enterPassword(password);
        register.enterConfirmPassword(password);
    }

    @And("user are completed all fields except password")
    public void userAreCompletedAllFieldsExceptPassword() {
        register.enterName(JavaHelper.generateRandomName());
        register.enterPhoneNum(JavaHelper.generateRandomPhoneNumber());
        register.enterBusinessName(JavaHelper.generateRandomJob());
        register.selectBusinessType("Toko Retail");
        register.enterEmail(JavaHelper.generateRandomEmail());
    }
}
