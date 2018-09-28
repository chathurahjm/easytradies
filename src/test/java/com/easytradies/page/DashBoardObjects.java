package com.easytradies.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardObjects
{
    WebDriver driver;
    public @FindBy(css = "div.header.item")WebElement HeaderText;

    public @FindBy(css = "i.users.large.circular.icon")WebElement EmpIcon;

    public @FindBy(css = "i.teal.users.large.icon")WebElement EmployersIcon;

    public @FindBy(css = "i.black.suitcase.large.icon")WebElement JobsIcon;

    public @FindBy(css = "i.black.law.large.icon")WebElement DisputeIcon;

    public @FindBy(css = "i.black.share.square.large.icon")WebElement ExportIcon;

    public DashBoardObjects(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
