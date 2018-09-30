package com.easytradies.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ContractorSignUpObjects {


    WebDriver driver;

    public @FindBy(className = "ant-input-number-input")
    WebElement HourlyRate ;

    public @FindBy(id = "skill_Builder")
    WebElement skill_Builder_Toggel ;

    public @FindBy(css = "a.btn.btn-login")
    WebElement SaveBttn ;

    public @FindBy(css = "input.ant-calendar-picker-input.ant-input")
    WebElement calendarPicker ;

    public @FindBy(className = "ant-calendar-input")
    WebElement calendarInput;



    public @FindBy(id = "ContactNumber")
    WebElement ContactNumber ;

    public @FindBy(id = "IRDNumber")
    WebElement IRDNumber ;

    public @FindBy(id = "GSTNumber")
    WebElement GSTNumber ;

    public @FindBy(className = "ant-select-selection__placeholder")
    List<WebElement> city ;

    public @FindBy(css = "a.btn.btn-login")
    WebElement save ;

    public @FindBy(className = "ant-alert-message")
    WebElement alertMsg ;


    //For Mailinator
    public @FindBy(id = "inboxfield")
    WebElement inboxfield ;

    public @FindBy(className = "input-group-btn")
    WebElement go ;

    public @FindBy(tagName = "li")
    List<WebElement> emailList ;

    public @FindBy(className = "table-responsive")
    WebElement Emailtable;



    public @FindBy(className = "button_link")
    WebElement button_link ;

    public @FindBy(className = "all-features")
    WebElement successTxt;









    public ContractorSignUpObjects(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
