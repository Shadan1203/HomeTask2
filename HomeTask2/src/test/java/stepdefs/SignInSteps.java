package stepdefs;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.example.pages.SignInPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignInSteps {
	private WebDriver driver;
	private SignInPage signInPage;

	public SignInSteps(WebDriver driver) {
		this.driver = driver;
	}

	@Given("the user is on the sign-in page")
	public void theuserisonsigninpage() {
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
	}

	@When("the user enters valid credentials")
	public void theUserEntersValidCredentials() {
		signInPage.enterEmail("testuser@example");
		signInPage.enterPassword("Password");
		signInPage.submitSignInForm();
	}

	@Then("the user should be signed in successfully")
	public void theUserShouldSignedInSuccessfully() {
		assertTrue(driver.getPageSource().contains("Welcome to your account"));
	}

	@Given("the user is on the Login page")
	public void theuserisonLoginpage() {
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
		Assert.assertTrue(driver.getPageSource().contains("sign in"));
	}

	@When("the user enters invalid credentials")
	public void theUserEntersInvalidCredentials() {
		signInPage.enterEmail("testuser@example");
		signInPage.enterPassword("Wrong password");
		signInPage.submitSignInForm();
	}

	@Then("the user should see an error message")
	public void theUserShouldSeeAnErrorMessage() {
		assertTrue(driver.getPageSource().contains("Authentication failed"));
	}

	@Given("the user is signed in")
	public void theUserIsSignedIn() {
		theUseIsOnTheSignInPage();
		theUserEntersValidCredentials();
		theUserShouldSignedInSuccessfully();
	}

	private void theUseIsOnTheSignInPage() {
		// TODO Auto-generated method stub
		
	}

	@When("the user signs out")
	public void theUserSignsOut() {
		driver.findElement(By.className("logout")).click();
	}

	@Then("the user should be signed out successfully")
	public void theUserShouldBeSignedOutSuccessfully() {
		assertTrue(driver.getPageSource().contains("sign in"));
	}

}
