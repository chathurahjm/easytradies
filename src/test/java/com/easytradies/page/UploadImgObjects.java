package com.easytradies.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.xml.dom.OnElementList;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.util.List;

public class UploadImgObjects {

    WebDriver driver;

    public  @FindBy(css="i.anticon.anticon-profile")WebElement My_Details;
    public  @FindBy(className="ant-upload")WebElement uploaderBtn;
    public  @FindBy(css="ul.ant-menu.ant-menu-light.ant-menu-root.ant-menu-inline")WebElement SideMenu;

    public  @FindBy(className="ant-card-cover")WebElement ProfileImage;


    public void ClickOnMyDetails()
    {
        List<WebElement> elm = SideMenu.findElements(By.tagName("li"));
        elm.get(5).click();

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void UploadImage() {
        Actions action = new Actions(driver);
        action.moveToElement(uploaderBtn).build().perform();
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        uploaderBtn.click();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            StringSelection s = new StringSelection("C:\\Users\\cja\\Pictures\\w.png");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
            Robot robot = new Robot();

            robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
            robot.keyPress(java.awt.event.KeyEvent.VK_V);
            robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
            Thread.sleep(3000);
            robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public String GetUploadImgURL()
    {
        String URL = ProfileImage.findElement(By.tagName("img")).getAttribute("src");

        return URL;

    }

    public UploadImgObjects(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
