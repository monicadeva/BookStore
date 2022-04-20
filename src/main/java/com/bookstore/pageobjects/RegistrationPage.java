package com.bookstore.pageobjects;

import com.bookstore.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BaseClass {
    WebDriver ldriver;

    public RegistrationPage(WebDriver ldriver) {
        this.ldriver = ldriver;
        PageFactory.initElements(ldriver, this);
    }

    @FindBy(id = "newUser")
    WebElement btnNewUser;

    @FindBy(id = "firstname")
    WebElement txtBoxFirstName;

    @FindBy(id = "lastname")
    WebElement txtBoxLastName;

    @FindBy(id = "userName")
    WebElement txtBoxUserName;

    @FindBy(id = "password")
    WebElement txtBoxPassword;

    @FindBy(xpath = "//label[@id='recaptcha-anchor-label']")
    WebElement captcha;

    @FindBy(id = "register")
    WebElement btnRegister;

    public void setBtnNewUser() {
        btnNewUser.click();
    }

    public void setTxtBoxFirstName(String firstName) {
        txtBoxFirstName.sendKeys(firstName);
    }

    public void setTxtBoxLastName(String lastName) {
        txtBoxLastName.sendKeys(lastName);
    }

    public void setTxtBoxUserName(String userName) {
        txtBoxUserName.sendKeys(userName);
    }

    public void setTxtBoxPassword(String passWord) {
        txtBoxPassword.sendKeys(passWord);
    }

    public void setBtnRegister() {
        scrollByVisibilityOfElement(ldriver,btnRegister);
        btnRegister.click();
    }
}
