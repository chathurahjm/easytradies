package com.easytradies;

import com.easytradies.page.LoginPageObjects;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.*;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Setup {


    public static WebDriver driver;
    LoginPageObjects LoginObj;

    public static  ExtentReports Extent;
    public static  ExtentTest Test ;
    public static ITestContext TestContext;
    public String emailIDEMP ="emp"+System.currentTimeMillis();

    public  void UserLogin(String Username,String Password)
    {
        LoginObj = new LoginPageObjects(driver);
        LoginObj.UserNameTxtBx.sendKeys(Username);
        LoginObj.PassWordNameTxtBx.sendKeys(Password);
        LoginObj.LoginBttn.click();

        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException ie){
        }
    }
//
//    public  void UserLoginLive_Employee1(String Username,String Password)
//    {
//        WaitForLoginPageToLoad1();
//        LoginObj = new LoginPageObjects(driver);
//        LoginObj.Live_UserNameTxtBx.sendKeys(Username);
//        LoginObj.Live_PassWordNameTxtBx.sendKeys(Password);
//        LoginObj.Live_signupEmployeeBtn.click();
//
//        try{
//            Thread.sleep(6000);
//        }
//        catch(InterruptedException ie){
//        }
//
//    }
//    public  void ContractorLogin1(String Username,String Password)
//    {
//        WaitForLoginPageToLoad();
//        LoginObj = new LoginPageObjects(driver);
//        LoginObj.Live_UserNameTxtBx.sendKeys(Username);
//        LoginObj.Live_PassWordNameTxtBx.sendKeys(Password);
//        try{
//            Thread.sleep(6000);
//        }
//        catch(InterruptedException ie){
//        }
//        LoginObj.Live_signupEmployeeBtn.click();
//
//        try{
//            Thread.sleep(6000);
//        }
//        catch(InterruptedException ie){
//        }
//
//    }


     public void InitDriver()
     {
         System.setProperty("webdriver.chrome.driver","C:\\Driver\\2.41.0\\chromedriver.exe");
         driver = new ChromeDriver();
         //driver.get("http://52.39.200.93:8000");
     }

    public void InitDriverLive()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Driver\\2.41.0\\chromedriver.exe");
        driver = new ChromeDriver();
        //driver.get("https://easytradies.com/sign-in-employee");
        driver.get("https://easytradies.com");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

     @BeforeSuite
     public void BeforeSuite()
     {
         Extent = new ExtentReports("C:\\Driver\\Reports\\extent.html", true);

     }

    @AfterSuite
    public void BeforeSuite2()
    {

        Extent.flush();


        Extent.close();
    }

//    public void WaitForLoginPageToLoad1() {
//        LoginObj = new LoginPageObjects(driver);
//
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement element = wait .until(ExpectedConditions.visibilityOf(LoginObj.Live_UserNameTxtBx));
//
//       /* if (LoginObj.UserNameTxtBx.isDisplayed()!=true)
//        {
//            String aa="asd";
//        }
//        else {
//            try {
//                Thread.sleep(3000);
//            }
//            catch(InterruptedException e) {
//                WaitForLoginPageToLoad();
//            }
//        }*/
//
//
//    }

    public void closeTab()
    {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_W);
        robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
