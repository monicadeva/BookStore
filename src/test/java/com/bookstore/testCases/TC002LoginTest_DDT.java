package com.bookstore.testCases;

import com.bookstore.base.BaseClass;
import com.bookstore.pageobjects.LoginPage;
import com.bookstore.utilities.Log;
import com.bookstore.utilities.XLUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC002LoginTest_DDT extends BaseClass {

    @Test(dataProvider="LoginData")
    public void loginTest(String user,String pwd) throws IOException {
        LoginPage lp = new LoginPage(driver);
        Log.info("URL opened.");
        lp.setUserName(user);
        Log.info("Username entered.");
        lp.setPassword(pwd);
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
        if(user.equals("mons") && pwd.equals("Mons@2504")) {
            Assert.assertTrue(true);
            Log.info("Login Successful.");
        }
        else {
            Assert.assertTrue(false,lp.getErrorMsg());
            Log.info("Invalid User Details");
            screenShot(driver,"loginTestDDT");
        }
        lp.clickLogout();
    }

    @DataProvider(name="LoginData")
    public Object [][] getData() throws IOException {
        Object[][] loginData = new Object[0][];
        try {
            String path = this.getClass().getClassLoader().getResource("LoginData.xlsx").toURI().getPath();
            int rowNum = XLUtils.getRowCount(path, "Sheet1");
            int colCount = XLUtils.getCellCount(path, "Sheet1", 1);
            loginData = new String[rowNum][colCount];
            for (int i = 1; i <= rowNum; i++) {
                for (int j = 0; j < colCount; j++) {
                    loginData[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);//1 0
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return loginData;
    }
}
