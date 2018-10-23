package com.easytradies.test;

import com.easytradies.Setup;
import com.easytradies.page.ContractorDashBoardObjects;
import com.easytradies.page.EmployeDashboardObjects;
import com.easytradies.page.LoginPageObjects;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAddTime extends Setup {

    //public String signInEmployeeURL = "https://www.etprelive.com/sign-in-employee";

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
    public void ValidateAdminAccept30MinReduction()
    {


        String empEmail=emailIDEMP;
        String actualEmailEmp = empEmail+"@mailinator.com";

        Test = Extent.startTest("Validate  Admin Accept 30Min Reduction");
         TestSignUpProcess SignUp = new TestSignUpProcess();
        //SignUp.ValidateSuccessUserEmp(empEmail);

        EmployeDashboardObjects empDash = new EmployeDashboardObjects(driver);
        empDash.Login("emp1538271145724");
        //empDash.CreateTeam();
        //empDash.AddCreditCard();
        //driver.close();


        //SignUp.ValidateSuccessContractorSignUpProcess();
        LoginPageObjects login = new LoginPageObjects(driver);
        driver.get(signInContractorURL);
        login.UserLogin("contract1538299779494@mailinator.com","test123");
        ContractorDashBoardObjects conDash = new ContractorDashBoardObjects(driver);
        //conDash.AddAccountInfo();
        //conDash.ApplyForTeam();
        conDash.LogOff();
        //

        //sup.closeTab();
        empDash.Login("emp1538271145724");
        //need to change the team id
        //empDash.EmployeeApproveContractor();
        conDash.LogOff();


        driver.get(signInContractorURL);
        login.UserLogin("contract1538299779494@mailinator.com","test123");
        conDash.AddTime();
        conDash.LogOff();

        empDash.Login("emp1538271145724");
        empDash.changeToOrdinary();
        conDash.LogOff();

        driver.get(signInContractorURL);
        login.UserLogin("contract1538299779494@mailinator.com","test123");








    }

}
