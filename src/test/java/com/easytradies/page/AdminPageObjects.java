package com.easytradies.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdminPageObjects {

    WebDriver driver;
    public  AdminPageObjects(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public @FindBy(name = "Email")
    WebElement Email;

    public @FindBy(name = "Password")
    WebElement Password;

    public @FindBy(css = "button.ui.button")
    WebElement login;

    public @FindBy(className = "item")
    List<WebElement> sideMenuItems;

    public @FindBy(css = "div.ui.basic.label")
    List<WebElement> sortButton;

    public @FindBy(css = "button.ui.green.button")
    List<WebElement> greenBttn;









}
