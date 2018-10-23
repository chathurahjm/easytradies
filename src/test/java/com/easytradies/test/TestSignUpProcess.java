package com.easytradies.test;
import com.easytradies.Setup;
import com.easytradies.Support;
import com.easytradies.page.*;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestSignUpProcess extends Setup{

    WebDriverWait wait;

    ContractorSignUpObjects CSingnUpObj;
    AdminPageObjects adminObj;
    EmployeDashboardObjects creatTeamObj;
    //String emailIDEMP ="contract"+System.currentTimeMillis() ;
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


    @Test
    public void ValidateSuccessUserEmp()
    {

        Test = Extent.startTest("Validate Success User Sign Up Process");
        String email = emailIDEMP;

//        ESignUpObj = new EmployerSignUpObjects(driver);
//        ESignUpObj.EmpSignUp.get(1).click();
//        try{
//            Thread.sleep(5000);
//        }
//        catch(InterruptedException ie){
//        }

        driver.get(signInEmployerURL);
        EmployerSignUpObjects ESignUpObj = new EmployerSignUpObjects(driver);
        ESignUpObj.Email.sendKeys(email+"@mailinator.com");
        ESignUpObj.Password.sendKeys("test123");

        ESignUpObj.tandc.click();
        ESignUpObj.SignUp.click();

        try{
            Thread.sleep(6000);
        }
        catch(InterruptedException ie){
        }

        ESignUpObj = new EmployerSignUpObjects(driver);
        ESignUpObj.FirstName.sendKeys("Employer1");
        ESignUpObj.LastName.sendKeys("Employer Last");
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException ie){
        }
        ESignUpObj.CompanyName.sendKeys("Homeland");
        ESignUpObj.PriConName.sendKeys("Sue");
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException ie){
        }
        ESignUpObj.ContactNo.sendKeys("0210101121");
        ESignUpObj.Street.sendKeys("11/21");
        ESignUpObj.Suburb.sendKeys("One Tree Hill");
        ESignUpObj.City.sendKeys("Auckland");
        ESignUpObj.PostalCode.sendKeys("1010");
        try{
            Thread.sleep(4000);
        }
        catch(InterruptedException ie){
        }
        ESignUpObj.Save.click();

        try{
            Thread.sleep(12000);
        }
        catch(InterruptedException ie){
        }

        Support sup = new Support();
        sup.verifyEmail(emailIDCON);

        //3 is for employees
        AdminApproveUser(3);

    }



    public void AdminApproveUser(int sideMenuIndex)
    {
        driver.get("http://54.200.96.164");
        AdminPageObjects admin  = new AdminPageObjects(driver);
        admin.AdminLogin();
        admin.UserApprove(sideMenuIndex);

        try{
            Thread.sleep(8000);
        }
        catch(InterruptedException ie){
        }

    }

    @Test
    public void ValidateSuccessContractorSignUpProcess()
    {
        Test = Extent.startTest("Validate Success Contractor Sign Up Process");
        EmployerSignUpObjects ESignUpObj = new EmployerSignUpObjects(driver);
        ESignUpObj = new EmployerSignUpObjects(driver);
        CSingnUpObj = new ContractorSignUpObjects(driver);

        ESignUpObj.EmpSignUp.get(0).click();
        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException ie){
        }

        String emailIDCON ="contract"+System.currentTimeMillis() ;
        ESignUpObj.Email.sendKeys(emailIDCON+"@mailinator.com");
        ESignUpObj.Password.sendKeys("test123");
        //ESignUpObj.tandc.click();
        ESignUpObj.SignUp.click();

        try{
            Thread.sleep(15000);
        }
        catch(InterruptedException ie){
        }


        CSingnUpObj.HourlyRate.clear();
        CSingnUpObj.HourlyRate.sendKeys("18");
        CSingnUpObj.skill_Builder_Toggel.click();

        CSingnUpObj.SaveBttn.click();
        try{
            Thread.sleep(15000);
        }
        catch(InterruptedException ie){
        }

        ESignUpObj.FirstName.sendKeys("TestContractor1");
        ESignUpObj.LastName.sendKeys("TestLastName");
        CSingnUpObj.calendarPicker.click();
        CSingnUpObj.calendarInput.click();
        CSingnUpObj.calendarInput.sendKeys("13-05-1998");
        CSingnUpObj.ContactNumber.sendKeys("0776179936");
        CSingnUpObj.IRDNumber.sendKeys("234234234");
        CSingnUpObj.GSTNumber.sendKeys("33234234");
        ESignUpObj.Street.sendKeys("street 01");
        ESignUpObj.Suburb.sendKeys("TestSuburb");
        CSingnUpObj.city.get(1).click();
        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException ie){
        }
        Keyboard keyboard=((HasInputDevices) driver).getKeyboard();

        keyboard.pressKey(Keys.ENTER);
        CSingnUpObj.save.click();
        try{
            Thread.sleep(12000);
        }
        catch(InterruptedException ie){
        }

        assertTrue(CSingnUpObj.alertMsg.getText().contains("Congratulations on creating an account"));

        Support sup = new Support();
        sup.verifyEmail(emailIDCON);

        //2 is for sidemenu contractors
        AdminApproveUser(2);


    }





    private class Select {
    }
}
