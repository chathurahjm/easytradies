package com.easytradies.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class EmployerSignUpObjects {
    WebDriver driver;

    public @FindBy(css = "a.btn.bat-call-to-act")List<WebElement> EmpSignUp;

    public @FindBy(id = "Email")WebElement Email;

    public @FindBy(id = "Password")WebElement Password;

    public @FindBy(id = "tos")WebElement tandc;

    public @FindBy(css="a.btn.btn-login")WebElement SignUp;
    public @FindBy(css="a.btn.btn-login")WebElement SignIn;

    public @FindBy(id = "FirstName")WebElement FirstName;

    public @FindBy(id = "LastName")WebElement LastName;

    public @FindBy(id = "CompanyName")WebElement CompanyName;

    public @FindBy(id = "PrimaryContactName")WebElement PriConName;

    public @FindBy(id = "PhoneNumber")WebElement ContactNo;

    public @FindBy(id = "Street")WebElement Street;

    public @FindBy(id = "Subrub")WebElement Suburb;

    public @FindBy(id = "City")WebElement City;

    public @FindBy(id = "PostalCode")WebElement PostalCode;

    public @FindBy(css = "a.btn.btn-login")WebElement Save;

    public EmployerSignUpObjects(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    public void employer_SignUp(String uid, String pw) throws InterruptedException{
//
//        Email.sendKeys(uid);
//        Password.sendKeys(pw);
//        tandc.click();
//        SignUp.click();
//
//    }
//
//    public void employer_SignUpProcess(String uid, String pw,String fname, String lname,String cname, String pcn,String cn,String st, String sub, String city,String pcode) throws InterruptedException{
//
//        Email.sendKeys(uid);
//        Password.sendKeys(pw);
//        tandc.click();
//        SignUp.click();
//        Thread.sleep(5000);
//        FirstName.sendKeys(fname);
//        LastName.sendKeys(lname);
//        CompanyName.sendKeys(cname);
//        PriConName.sendKeys(pcn);
//        ContactNo.sendKeys(cn);
//        Street.sendKeys(st);
//        Suburb.sendKeys(sub);
//        City.sendKeys(city);
//        PostalCode.sendKeys(pcode);
//        Save.click();
//
//    }
}