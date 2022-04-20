package com.bookstore.pageobjects;

import com.bookstore.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class BookStorePage extends BaseClass {
    WebDriver ldriver;

    public BookStorePage(WebDriver ldriver) {
        this.ldriver = ldriver;
        PageFactory.initElements(ldriver, this);
    }

    @FindBy(xpath = "//span[text()='Book Store']")
    @CacheLookup
    WebElement labelBookStore;

    @FindBy(xpath = "//div[@class='rt-tbody'] //a")
    @CacheLookup
    List<WebElement> links;

    @FindBy(xpath = "//*[text()='Add To Your Collection']")
    @CacheLookup
    WebElement btnAddBook;

    @FindBy(xpath = "//*[text()='Back To Book Store']")
    @CacheLookup
    WebElement btnBack;

    public void setLabelBookStore() {
        scrollByVisibilityOfElement(driver,labelBookStore);
        labelBookStore.click();
    }

    public void setLinks(int i) {
        if (links.get(i).isDisplayed())
            links.get(i).click();

        else if (!(links.get(i).isDisplayed())) {
            scrollByVisibilityOfElement(driver,links.get(i));
            links.get(i).click();
        }
    }

    public void setBtnAddBook () {
        scrollByVisibilityOfElement(driver,btnAddBook);
        btnAddBook.click();
    }

    public void setBtnBack () {
        scrollByVisibilityOfElement(driver,btnBack);
        btnBack.click();
    }
}
