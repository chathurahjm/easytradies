package com.easytradies.test;
import com.easytradies.Setup;
import com.easytradies.page.DashBoardObjects;
import com.easytradies.page.LoginPageObjects;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public  class TestInitial extends Setup
{
    /**
     * Rigorous Test :-)
     */

    WebDriverWait wait;
    LoginPageObjects LoginObj;
    DashBoardObjects DashObj;

    @BeforeClass
    public  static void ClassInitialization()
    {
        Setup set = new Setup();
        set.InitDriver();
    }

    @AfterClass
    public  static void ClassCleanup()
    {
        driver.quit();
    }

    @AfterMethod
    public  void AfterEachTest(ITestResult result)
    {
        if (result.getStatus() == ITestResult.FAILURE)
        {
            Test.log(LogStatus.FAIL, "Test Fail");
        }

        else
        {
            Test.log(LogStatus.PASS, "Test Pass");
        }
        Extent.endTest(Test);

    }

    @Test
    public void ValidateSuccessUserLogin()
    {
        Test = Extent.startTest("Validate Success User Login");

        LoginObj = new LoginPageObjects(driver);
        LoginObj.UserNameTxtBx.sendKeys("admin@easytradies.co.nz");
        LoginObj.PassWordNameTxtBx.sendKeys("Janitha@1234");
        LoginObj.LoginBttn.click();

        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException ie){
        }

        DashObj= new DashBoardObjects(driver);
        String header = DashObj.HeaderText.getText();
        assertEquals("Easy Tradies Dashboard",header);

    }

    @Test
    public void ValidateSuccessUserLogin2()
    {
        Test = Extent.startTest("Validate view system settings2");
        LoginObj = new LoginPageObjects(driver);
        LoginObj.UserNameTxtBx.sendKeys("admin@easytradies.co.nz");
        LoginObj.PassWordNameTxtBx.sendKeys("Janitha@1234");
        LoginObj.LoginBttn.click();

        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException ie){
        }

        DashObj= new DashBoardObjects(driver);
        String header = DashObj.HeaderText.getText();
        assertEquals("Easy Tradies Dashboard",header);

    }


}
