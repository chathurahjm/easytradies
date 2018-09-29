package com.easytradies.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public @FindBy(css = "button.ant-btn.ant-btn-primary")
    List<WebElement> CreateTeam;
}
