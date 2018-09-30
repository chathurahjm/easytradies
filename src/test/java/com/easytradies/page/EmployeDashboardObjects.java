package com.easytradies.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
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

    public @FindBy(className = "ant-calendar-today-btn")
    WebElement today;


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
    public @FindBy(className = "__PrivateStripeElement")
    List<WebElement> expDate2;


    public @FindBy(css = "div.__PrivateStripeElement")
    WebElement CVC;
    //End credi card
    //Start approve contractor

    public @FindBy(className = "_3MXL3")
    List<WebElement> teamlist;

    public @FindBy(css = "button.ant-btn.ant-btn-primary.ant-btn-sm")
    List<WebElement> hire;

    //end approve contractor

    //Start ViewTimeSheets
    public @FindBy(css = "a.ant-btn.ant-btn-primary")
    WebElement ViewTimeSheets;

    public @FindBy(className = "ant-select-selection__rendered")
    WebElement DayTypeDropDown;

    public @FindBy(className = "div.ant-row.ant-form-item")
    WebElement TopLayerOfApproveBttn;

    public @FindBy(className = "ant-input")
    List<WebElement> Reason;






    public void Login(String userID){
        driver.get("https://easytradies.com/sign-in-employer");

        try{
            Thread.sleep(8000);
        }
        catch(InterruptedException ie){
        }

        EmployerSignUpObjects ESignUpObj = new EmployerSignUpObjects(driver);

        ESignUpObj.Email.sendKeys(userID+"@mailinator.com");
        ESignUpObj.Password.sendKeys("test123");
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
        try{
            Thread.sleep(4000);
        }
        catch(InterruptedException ie){
        }
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
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException ie){
        }
        //calendarInput.click();
        //calendarInput.sendKeys("2018-09-29");
        today.click();
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException ie){
        }
        cityTxtBx.click();
        try{
            Thread.sleep(4000);
        }
        catch(InterruptedException ie){
        }
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

        //Login();
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


        //driver.switchTo().frame(1);
        //cardnumber.sendKeys("4242424242424242");

        //driver.switchTo().frame(0);
        //driver.switchTo().defaultContent();
        Keyboard keyboard=((HasInputDevices) driver).getKeyboard();
        keyboard.pressKey(Keys.TAB);
        try{
            Thread.sleep(4000);
        }
        catch(InterruptedException ie){
        }
        //keyboard.sendKeys("378282246310005");
        StringSelection s = new StringSelection("378282246310005");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
        robot.keyPress(java.awt.event.KeyEvent.VK_V);
        robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try{
            Thread.sleep(4000);
        }
        catch(InterruptedException ie){
        }
        keyboard.pressKey(Keys.TAB);
        keyboard.sendKeys("1222");
        try{
            Thread.sleep(4000);
        }
        catch(InterruptedException ie){
        }
        keyboard.pressKey(Keys.TAB);
        try{
            Thread.sleep(4000);
        }
        catch(InterruptedException ie){
        }
        keyboard.sendKeys("123");
       // keyboard.pressKey(Keys.TAB);
        try{
            Thread.sleep(4000);
        }
        catch(InterruptedException ie){
        }

        keyboard.pressKey(Keys.TAB);
        try{
            Thread.sleep(4000);
        }
        catch(InterruptedException ie){
        }
        //Click on save buttn
        keyboard.pressKey(Keys.ENTER);
        try{
            Thread.sleep(10000);
        }
        catch(InterruptedException ie){
        }

    }

    public void  EmployeeApproveContractor()
    {

        try{
            Thread.sleep(4000);
        }
        catch(InterruptedException ie){
        }

        teamlist.get(0).click();
        try{
            Thread.sleep(6000);
        }
        catch(InterruptedException ie){
        }
        hire.get(0).click();
        try{
            Thread.sleep(8000);
        }
        catch(InterruptedException ie){
        }

    }

    public void changeToOrdinary()
    {
//time sheet button
        SideMenuList.get(4).click();
        try{
            Thread.sleep(8000);
        }
        catch(InterruptedException ie){
        }

        ViewTimeSheets.click();
        try{
            Thread.sleep(8000);
        }
        catch(InterruptedException ie){
        }

        //change existing "Holiday" date type to normal
        DayTypeDropDown.click();
        Keyboard keyboard=((HasInputDevices) driver).getKeyboard();
        keyboard.pressKey(Keys.ARROW_UP);
        keyboard.pressKey(Keys.ENTER);

        Reason.get(1).sendKeys("Test reason");
        TopLayerOfApproveBttn.findElement(By.cssSelector("button.ant-btn.ant-btn-primary")).click();

        try{
            Thread.sleep(8000);
        }
        catch(InterruptedException ie){
        }

    }
}
