package com.easytradies.test;
import com.easytradies.Setup;
import com.easytradies.page.DashBoardObjects;
import com.easytradies.page.LoginPageObjects;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;
import static org.testng.ITestResult.*;


public class TestDashBoard extends Setup
{

    DashBoardObjects DashObj;
    @BeforeClass
    public static void ClassInitialization()
    {
        Setup set = new Setup();
        set.InitDriver();
        set.UserLogin("admin@easytradies.co.nz","Janitha@1234");
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
    public void Validate_Availability_Of_Employees_Icon()
    {
        Test = Extent.startTest("Validate Availability Of Employees Icon");
        DashObj = new DashBoardObjects(driver);
        assertTrue(DashObj.EmpIcon.isDisplayed());
    }

    @Test
    public void Validate_Availability_Of_Employers_Icon()
    {
        Test = Extent.startTest("Validate Availability Of Employers Icon");
        DashObj = new DashBoardObjects(driver);
        assertTrue(DashObj.EmployersIcon.isDisplayed());
    }

    @Test
    public void Validate_Availability_Of_Jobs_Icon()
    {
        Test = Extent.startTest("Validate Availability Of Jobs Icon");
        DashObj = new DashBoardObjects(driver);
        assertTrue(DashObj.JobsIcon.isDisplayed());
    }

    @Test
    public void Validate_Availability_Of_Dispute_Icon()
    {
        Test = Extent.startTest("Validate Availability Of Dispute Icon");
        DashObj = new DashBoardObjects(driver);
        assertTrue(DashObj.DisputeIcon.isDisplayed());
    }

    @Test
    public void Validate_Availability_Of_Export_Icon()
    {
        Test = Extent.startTest("Validate Availability Of Export Icon");
        DashObj = new DashBoardObjects(driver);
        assertTrue(DashObj.ExportIcon.isDisplayed());
    }




}
