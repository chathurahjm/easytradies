package com.easytradies.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AdminPageObjects {

    WebDriver driver;
    public  AdminPageObjects(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
