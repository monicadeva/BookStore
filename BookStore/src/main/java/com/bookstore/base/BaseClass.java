package com.bookstore.base;

import com.bookstore.utilities.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;

public class BaseClass {

    ReadConfig readConfig = new ReadConfig();

    public String baseURL = readConfig.getApplicationURL();
    public String username = readConfig.getUserName();
    public String password = readConfig.getPassword();
    public static WebDriver driver;
    public JavascriptExecutor Js1;

    @Parameters("browser")
    @BeforeClass
    public  void launchApp(String browserName) {

        if(browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver",readConfig.getChromePath());
            driver = new ChromeDriver();
            ChromeOptions opt = new ChromeOptions();
            opt.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        }

        if(browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver",readConfig.getFirefoxPath());
            driver = new FirefoxDriver();
        }

        if(browserName.equals("edge")) {
            System.setProperty("webdriver.edge.driver",readConfig.getEdgePath());
            driver = new EdgeDriver();
            EdgeOptions opt = new EdgeOptions();
            opt.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        driver.get(baseURL);
    }

    public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public void implicitWait(WebDriver driver, int timeOut) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void explicitWait(WebDriver driver, WebElement element, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void pageLoadTimeOut(WebDriver driver, int timeOut) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeOut));
    }

    public String screenShot(WebDriver driver, String filename) throws IOException {
        TakesScreenshot ts =  (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File dst = new File("../Screenshots/"+filename+".png");
        FileUtils.copyFile(src,dst);
        System.out.println("Screenshot Taken");
        return filename;
    }

    public boolean isAlertPresent(WebDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

