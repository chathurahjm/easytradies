package com.easytradies.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedHashSet;
import java.util.List;

public class EmployeDashboardObjects {

    WebDriver driver;
    public EmployeDashboardObjects(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public @FindBy(css = "button.ant-btn.ant-btn-primary")
    List<WebElement> CreateTeam;

    public @FindBy(css = "div.ant-select-selection.ant-select-selection--single")
    WebElement jobCategory;

    public @FindBy(id = "TeamCount")
    WebElement TeamCount;

    public @FindBy(id = "TeamName")
    WebElement TeamName;

    public @FindBy(id = "discription")
    WebElement discription;

    public @FindBy(css = "input.ant-calendar-picker-input.ant-input")
    WebElement calendarPicker ;

    public @FindBy(className = "ant-calendar-input")
    WebElement calendarInput;

    public @FindBy(className = "ant-select-search__field__placeholder")
    WebElement cityTxtBx;

    public @FindBy(css = "span.ant-select-tree-node-content-wrapper.ant-select-tree-node-content-wrapper-close")
    List<WebElement> cityList2;
    //End create team
    //start add CC
    public @FindBy(className = "ant-menu-item")
    List<WebElement> SideMenuList;

    public @FindBy(className = "ant-radio")
    WebElement PayFrom;

    public @FindBy(name = "cardnumber")
    WebElement cardnumber;

    public @FindBy(name = "exp-date")
    WebElement expDate;

    public @FindBy(css = "div.__PrivateStripeElement")
    WebElement CVC;





    public void Login(){
        driver.get("https://easytradies.com/sign-in-employer");

        EmployerSignUpObjects ESignUpObj = new EmployerSignUpObjects(driver);

        ESignUpObj.Email.sendKeys("er@mailinator.com");
        ESignUpObj.Password.sendKeys("redred");
        try{
            Thread.sleep(4000);
        }
        catch(InterruptedException ie){
        }
        ESignUpObj.SignIn.click();
        try{
            Thread.sleep(10000);
        }
        catch(InterruptedException ie){
        }
    }

    public void CreateTeam()
    {

        Login();
        CreateTeam.get(0).click();

        try{
            Thread.sleep(4000);
        }
        catch(InterruptedException ie){
        }
        jobCategory.click();
        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException ie){
        }
        //jobCategoryTxt2.sendKeys("Builder");
        Keyboard keyboard=((HasInputDevices) driver).getKeyboard();
        keyboard.sendKeys("Builder");
        keyboard.pressKey(Keys.ENTER);

        TeamCount.sendKeys("8");
        TeamName.sendKeys("DemoTeam");
        discription.sendKeys("Demodiscription");
        calendarPicker.click();
        calendarInput.click();
        calendarInput.sendKeys("2018-09-29");
        try{
            Thread.sleep(4000);
        }
        catch(InterruptedException ie){
        }
        cityTxtBx.click();
        cityList2.get(0).click();

        try{
            Thread.sleep(3000);
        }
        catch(InterruptedException ie){
        }

        CreateTeam.get(1).click();

        try{
            Thread.sleep(4000);
        }
        catch(InterruptedException ie){
        }
    }


    public void AddCreditCard()
    {

        Login();
        try{
            Thread.sleep(4000);
        }
        catch(InterruptedException ie){
        }
        SideMenuList.get(4).click();
        try{
            Thread.sleep(8000);
        }
        catch(InterruptedException ie){
        }
        PayFrom.click();
        driver.switchTo().frame(1);
        cardnumber.sendKeys("4242424242424242");

        driver.switchTo().defaultContent();
        try{
            Thread.sleep(4000);
        }
        catch(InterruptedException ie){
        }
        expDate.sendKeys("1222");
        CVC.sendKeys("154");
        //Click on save buttn
        CreateTeam.get(0).click();

    }
}
