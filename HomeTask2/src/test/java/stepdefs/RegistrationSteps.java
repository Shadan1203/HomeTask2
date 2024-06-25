package stepdefs;

import com.example.pages.RegistrationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;


public class RegistrationSteps {
    private WebDriver driver;
    private RegistrationPage registrationPage;

    public RegistrationSteps(WebDriver driver){
        this.driver = driver;
        this.registrationPage = new RegistrationPage(driver);
    }

    @Given("the user is on the registration page")
    public void theUserIsOnTheRegistrationPage(){
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
    }

    @When("the user enters valid details")
    public void theUserEntersValidDetails(){
        registrationPage.enterEmail("testuser@example.com");
        registrationPage.enterFirstName("Test");
        registrationPage.enterLastName("User");
        registrationPage.enterPassword("password");
        registrationPage.submitForm();
    }

    @Then("the user should be registered successfully")
    public void theUserShouldBeRegisteredSuccessfully(){
        assertTrue(driver.getPageSource().contains("Welcome to your account"));
    }

    @When("the user enters an already Email")
    public void theUserEntersAnAlreadyEmail(){
        registrationPage.enterEmail("alreadyregistered@example.com");
        registrationPage.submitForm();
    }

    @Then("the user should see error message")
    public void theUserShouldSeeErrorMessage(){
        assertTrue(driver.getPageSource().contains("An account using this email address has already been registered"));
    }

    @When("the user enters invalid details")
    public void theUserEntersInvalidDetails(){
        registrationPage.enterEmail("invalidEmail");
        registrationPage.enterFirstName("");
        registrationPage.enterLastName("");
        registrationPage.enterPassword("");
        registrationPage.submitForm();
    }

    @Then("the user should see validation error messages")
    public void theUserShouldSeeValidationErrorMessages(){
        assertTrue(driver.getPageSource().contains("There are 8 errors"));
    }

    }
