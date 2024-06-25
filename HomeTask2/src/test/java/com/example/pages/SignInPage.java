package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    private WebDriver driver;

    @FindBy(id = "email")
    private WebElement emailFields;

    @FindBy(id = "passwd")
    private WebElement passwordFields;

    @FindBy(id = "submitLogin")
    private WebElement signInButton;

    public SignInPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email){
        emailFields.sendKeys(email);
    }

    public void enterPassword(String password){
        passwordFields.sendKeys(password);
    }

    public void submitSignInForm(){
        signInButton.click();
    }
}
