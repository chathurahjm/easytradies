package com.easytradies.test;

import com.easytradies.Setup;
import com.easytradies.page.ContractorDashBoardObjects;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestContractorDashBoard extends Setup {

    @BeforeClass
    public  static void ClassInitialization()
    {
        Setup set = new Setup();
        set.InitDriverLive();
    }

    @AfterClass
    public  static void ClassCleanup()
    {
        driver.quit();
    }

    @AfterMethod
    public  void AfterEachTest(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            Test.log(LogStatus.FAIL, "Test Fail");
        } else {
            Test.log(LogStatus.PASS, "Test Pass");
        }
        Extent.endTest(Test);

    }

    @org.testng.annotations.Test
    public void AddAccountInfo()
    {
        Test = Extent.startTest("Validate  Contractor add Bank Details");
        ContractorDashBoardObjects conobj = new ContractorDashBoardObjects(driver);
        conobj.AddAccountInfo();
    }

    @org.testng.annotations.Test
    public void ApplyForATeam()
    {
        Test = Extent.startTest("Validate Contractor Apply For A Team");
        ContractorDashBoardObjects conobj = new ContractorDashBoardObjects(driver);
        conobj.ApplyForTeam();

    }
}
