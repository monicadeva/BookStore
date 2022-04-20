package com.bookstore.pageobjects;

import com.bookstore.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {
    WebDriver ldriver;

    public LoginPage(WebDriver ldriver) {
        this.ldriver = ldriver;
        PageFactory.initElements(ldriver, this);
    }

    @FindBy(id="userName")
    @CacheLookup
    WebElement txtBoxUsername;

    @FindBy(id="password")
    @CacheLookup
    WebElement txtBoxPassword;

    @FindBy(id="login")
    @CacheLookup
    WebElement btnLogin;

    @FindBy(id = "name")
    WebElement errorMsg;

    @FindBy(id = "submit")
    @CacheLookup
    WebElement btnLogout;

    public void setUserName(String uname) {
        txtBoxUsername.sendKeys(uname);
    }

    public void setPassword(String pwd) {
        txtBoxPassword.sendKeys(pwd);
    }

    public void clickLogin() {
        scrollByVisibilityOfElement(driver,btnLogin);
        btnLogin.click();
    }

    public String getErrorMsg() {
        return errorMsg.getText();
    }

    public void clickLogout() {
        btnLogout.click();
    }

}
