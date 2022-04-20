package com.bookstore.testCases;

import com.bookstore.base.BaseClass;
import com.bookstore.pageobjects.RegistrationPage;
import com.bookstore.utilities.Log;
import org.testng.annotations.Test;

public class Registration extends BaseClass {
    @Test
    public void registrationTest() {
        RegistrationPage rp = new RegistrationPage(driver);
        rp.setBtnNewUser();
        Log.info("New User Registration.");
        rp.setTxtBoxFirstName("Jason");
        Log.info("First Name entered.");
        rp.setTxtBoxLastName("T");
        Log.info("Last Name entered.");
        rp.setTxtBoxUserName("jason");
        Log.info("User Name entered.");
        rp.setTxtBoxPassword("Jason@2502");
        Log.info("Password entered.");
        rp.setBtnRegister();
        Log.info("Register User.");
    }
}
