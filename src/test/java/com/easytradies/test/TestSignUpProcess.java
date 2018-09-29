package com.easytradies.test;
import com.easytradies.Setup;
import com.easytradies.page.*;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestSignUpProcess extends Setup{

    WebDriverWait wait;
    EmployerSignUpObjects ESignUpObj;
    ContractorSignUpObjects CSingnUpObj;
    AdminPageObjects adminObj;
    EmployeDashboardObjects creatTeamObj;

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
    public void ValidateSuccessUserSignUpProcess()
    {
        Test = Extent.startTest("Validate Success User Sign Up Process");

        ESignUpObj = new EmployerSignUpObjects(driver);
        ESignUpObj.EmpSignUp.get(1).click();
        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException ie){
        }
        String emailIDEMP ="contract"+System.currentTimeMillis() ;
        ESignUpObj.Email.sendKeys(emailIDEMP+"@mailinator.com");
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
        ESignUpObj.CompanyName.sendKeys("Homeland");
        ESignUpObj.PriConName.sendKeys("Sue");
        ESignUpObj.ContactNo.sendKeys("0210101121");
        ESignUpObj.Street.sendKeys("11/21");
        ESignUpObj.Suburb.sendKeys("One Tree Hill");
        ESignUpObj.City.sendKeys("Auckland");
        ESignUpObj.PostalCode.sendKeys("1010");
        ESignUpObj.Save.click();

        try{
            Thread.sleep(12000);
        }
        catch(InterruptedException ie){
        }

        verifyEmail(emailIDEMP);

        //3 is for employees
        AdminApprove(3);


    }

    @Test
    public void CreateTeamByEmp()
    {
        Test = Extent.startTest("Validate Success Employee Create Teams");
        creatTeamObj = new EmployeDashboardObjects(driver);
        creatTeamObj.CreateTeam();

    }


    public void AdminApprove(int SideMenuID)
    {
        driver.get("http://52.39.200.93:8000");

        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException ie){
        }

        adminObj = new AdminPageObjects(driver);
        adminObj.Email.sendKeys("admin@easytradies.co.nz");
        adminObj.Password.sendKeys("Janitha@1234");
        adminObj.login.click();

        try{
            Thread.sleep(8000);
        }
        catch(InterruptedException ie){
        }
        adminObj.sideMenuItems.get(SideMenuID).click();

        try{
            Thread.sleep(8000);
        }
        catch(InterruptedException ie){
        }
        adminObj.sortButton.get(0).click();
        try{
            Thread.sleep(4000);
        }
        catch(InterruptedException ie){
        }
        adminObj.sortButton.get(0).click();
        try{
            Thread.sleep(4000);
        }
        catch(InterruptedException ie){
        }

        adminObj.greenBttn.get(1).click();



    }

    @Test
    public void ValidateSuccessContractorSignUpProcess()
    {
        Test = Extent.startTest("Validate Success Contractor Sign Up Process");

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


        verifyEmail(emailIDCON);

        //2 is for sidemenu contractors
        AdminApprove(2);


    }


    public void verifyEmail(String email){
        driver.get("https://www.mailinator.com");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CSingnUpObj = new ContractorSignUpObjects(driver);
        CSingnUpObj.inboxfield.sendKeys(email);
        CSingnUpObj.go.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CSingnUpObj.emailList.get(3).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       // CSingnUpObj2 = new ContractorSignUpObjects(driver);

        driver.switchTo().frame("msg_body");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String EmailURL = (CSingnUpObj.button_link.getAttribute("href"));

        driver.get(EmailURL);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String aa = CSingnUpObj.successTxt.getText();

    }


    private class Select {
    }
}
