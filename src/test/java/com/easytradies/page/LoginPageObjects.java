package com.easytradies.page;

import com.easytradies.test.TestInitial;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects
{
    WebDriver driver;


    public  @FindBy(name="Email")WebElement UserNameTxtBx;
    public  @FindBy(name="Password")WebElement PassWordNameTxtBx;
    public  @FindBy(css="button.ui.button")WebElement LoginBttn;

    public  @FindBy(name="email")WebElement Live_UserNameTxtBx;
    public  @FindBy(name="password")WebElement Live_PassWordNameTxtBx;
    public  @FindBy(css="a.btn.btn-login")WebElement Live_signupEmployeeBtn;



    public LoginPageObjects(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



}
