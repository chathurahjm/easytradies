package com.easytradies.page;

import com.easytradies.Setup;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ContractorDashBoardObjects {

    WebDriver driver;
    public ContractorDashBoardObjects(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public @FindBy(className = "ant-menu-item")
    List<WebElement> SideMenuItesm;
    //0,1,2,3,4,-6 for bank

    public @FindBy(id = "holderName")
    WebElement holderName;

    public @FindBy(id = "accountNumber")
    WebElement accountNumber;

    public @FindBy(css = "button.ant-btn.ant-btn-primary")
    WebElement save;
//end add account iinfo
    //start apply for a team
    public @FindBy(css = "button.ant-btn.ant-btn-primary.ant-btn-background-ghost")
    List<WebElement> Apply;

    //End apply for team

    //Start log out

    public @FindBy(className = "ant-menu-submenu-title")
    WebElement logOut;
    public @FindBy(id = "item_0$Menu")
    WebElement item_0$Menu;

    //end log out

    //start add time
    public @FindBy(id = "StartTime")
    WebElement StartTime;

    public @FindBy(id = "EndTime")
    WebElement EndTime;

    public @FindBy(id = "ProjectAddress")
    WebElement ProjectAddress;

    public @FindBy(className = "ant-select-selection__rendered")
    WebElement type;

    public @FindBy(css = "button.ant-btn.login-form-button.ant-btn-primary")
    WebElement TimeSave;

    public @FindBy(className = "ant-col-3")
    WebElement TopLayerOfRejectBttn;


    //End add time










    public void AddAccountInfo()
    {
        //Setup sup = new Setup();
        //driver.get("https://easytradies.com/sign-in-employee");
        //sup.ContractorLogin("contract1538142611337@mailinator.com","test123");
        SideMenuItesm.get(6).click();
        try{
            Thread.sleep(6000);
        }
        catch(InterruptedException ie){
        }
        holderName.clear();
        holderName.sendKeys("demoContractor");
        accountNumber.clear();
        accountNumber.sendKeys("23-4234-2342342-342");
        save.click();
        try{
            Thread.sleep(6000);
        }
        catch(InterruptedException ie){
        }
    }

    public void ApplyForTeam()
    {
        //Setup sup = new Setup();
       // driver.get("https://easytradies.com/sign-in-employee");
        //sup.ContractorLogin("contract1538142611337@mailinator.com","test123");
        SideMenuItesm.get(2).click();
        try{
            Thread.sleep(7000);
        }
        catch(InterruptedException ie){
        }
        Apply.get(0).click();
        //SideMenuItesm.get(2).click();
        try{
            Thread.sleep(7000);
        }
        catch(InterruptedException ie){
        }
    }

    public void AddTime()
    {
        SideMenuItesm.get(3).click();
        try{
            Thread.sleep(7000);
        }
        catch(InterruptedException ie){
        }
        StartTime.click();
        StartTime.sendKeys("7.00");
        EndTime.clear();
        EndTime.sendKeys("8.00");
        ProjectAddress.sendKeys("Test address");
        type.click();
        Keyboard keyboard=((HasInputDevices) driver).getKeyboard();
        keyboard.pressKey(Keys.ARROW_DOWN);
        keyboard.pressKey(Keys.ENTER);
        TimeSave.click();
        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException ie){
        }
    }


    public  void  RejectTime()
    {
        SideMenuItesm.get(3).click();
        try{
            Thread.sleep(7000);
        }
        catch(InterruptedException ie){
        }

        TopLayerOfRejectBttn.sc
    }
    public void  LogOff()
    {
        logOut.click();
        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException ie){
        }
        item_0$Menu.click();
    }

}
