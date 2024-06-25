package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    private WebDriver driver;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "submitAccount")
    private WebElement submitButton;

    @FindBy(id = "customer_firstname")
    private WebElement firstNameField;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email){
        emailField.sendKeys(email);
    }

    public void enterFirstName(String firstName){
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        lastNameField.sendKeys(lastName);
    }

    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }

    public void submitForm(){
        submitButton.click();
    }
}
