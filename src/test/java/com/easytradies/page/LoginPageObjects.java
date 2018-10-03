package com.easytradies.page;

import com.easytradies.test.TestInitial;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObjects
{
    WebDriver driver;


    public  @FindBy(name="Email")WebElement UserNameTxtBx;
    public  @FindBy(name="Password")WebElement PassWordNameTxtBx;
    public  @FindBy(css="button.ui.button")WebElement LoginBttn;

    //contractor
    public  @FindBy(name="email")WebElement Live_UserNameTxtBx;
    public  @FindBy(name="password")WebElement Live_PassWordNameTxtBx;
    public  @FindBy(css="a.btn.btn-login")WebElement Live_signupEmployeeBtn;

    //employee
    //public @FindBy(id = "Email")WebElement Email;
    //public @FindBy(id = "Password")WebElement Password;
    //public @FindBy(css="a.btn.btn-login")WebElement SignIn;

    public LoginPageObjects(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    public void EmployeeLogin(String username,String password,String URL){
//        driver.get(URL);
//
//        try{
//            Thread.sleep(8000);
//        }
//        catch(InterruptedException ie){
//        }
//
//        Email.sendKeys(username);
//        Password.sendKeys(password);
//        try{
//            Thread.sleep(4000);
//        }
//        catch(InterruptedException ie){
//        }
//        SignIn.click();
//        try{
//            Thread.sleep(10000);
//        }
//        catch(InterruptedException ie){
//        }
//    }

    public  void UserLogin(String username,String password)
    {
        WaitForLoginPageToLoad();

        Live_UserNameTxtBx.sendKeys(username);
        Live_PassWordNameTxtBx.sendKeys(password);
        try{
            Thread.sleep(6000);
        }
        catch(InterruptedException ie){
        }
        Live_signupEmployeeBtn.click();

        try{
            Thread.sleep(6000);
        }
        catch(InterruptedException ie){
        }

    }

    public void WaitForLoginPageToLoad() {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait .until(ExpectedConditions.visibilityOf(Live_UserNameTxtBx));

       /* if (LoginObj.UserNameTxtBx.isDisplayed()!=true)
        {
            String aa="asd";
        }
        else {
            try {
                Thread.sleep(3000);
            }
            catch(InterruptedException e) {
                WaitForLoginPageToLoad();
            }
        }*/

    }

    public void WaitForElementLoad(WebElement elm,int time) {

        WebDriverWait wait = new WebDriverWait(driver, time);
        WebElement element = wait .until(ExpectedConditions.visibilityOf(elm));

    }



}
