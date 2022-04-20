package com.bookstore.pageobjects;

import com.bookstore.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BaseClass {
    WebDriver ldriver;

    public ProfilePage(WebDriver ldriver) {
        this.ldriver = ldriver;
        PageFactory.initElements(ldriver, this);
    }

    @FindBy(xpath = "//span[text()='Profile']")
    WebElement labelProfile;

    @FindBy(xpath = "//button[text()='Delete All Books']")
    WebElement btnDeleteBooks;

    @FindBy(id = "userName-value")
    WebElement labelUserName;

    @FindBy(xpath = "//button[text()='Log out']")
    WebElement btnLogOut;

    public void setLabelProfile() {
        scrollByVisibilityOfElement(driver,labelProfile);
        labelProfile.click();
    }

    public void setBtnDeleteBooks() {
        btnDeleteBooks.click();
    }

    public String setLabelUserName() {
        return labelUserName.getText();
    }

    public void setBtnLogOut() {
        btnLogOut.click();
    }
}
