package com.bookstore.testCases;

import com.bookstore.base.BaseClass;
import com.bookstore.pageobjects.BookStorePage;
import com.bookstore.pageobjects.LoginPage;
import com.bookstore.pageobjects.ProfilePage;
import com.bookstore.utilities.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC003DeleteBook extends BaseClass {

    @Test
    public void profile() throws IOException {

        LoginPage lp = new LoginPage(driver);
        BookStorePage bsp = new BookStorePage(driver);
        ProfilePage pp = new ProfilePage(driver);
        Log.info("URL is opened.");
        lp.setUserName(username);
        Log.info("Username entered.");
        lp.setPassword(password);
        Log.info("Password entered.");
        lp.clickLogin();
        if(driver.getTitle().equals("ToolsQA")) {
            Assert.assertTrue(true);
            Log.info("Login Successful.");
        }
        else {
            screenShot(driver,"loginTest");
            Assert.assertTrue(false);
            Log.info("Login Unsuccessful.");
        }
        String userName = pp.setLabelUserName();
        if(username.equals(userName)) {
            Assert.assertTrue(true);
            Log.info("Verified User.");
        }
        else {
            screenShot(driver,"loginTest");
            Assert.assertTrue(false);
            Log.info("User Not Verified.");
        }
        //Viewing Profile
        pp.setLabelProfile();
        Log.info("User Profile opened.");
        //Deleting all books
        pp.setBtnDeleteBooks();
        if(isAlertPresent(driver)) {
            driver.switchTo().alert().accept();
            driver.switchTo().alert().accept();
        }
        Log.info("Books deleted.");
    }

}
