package com.easytradies.test;

import com.easytradies.Setup;
import com.easytradies.page.DashBoardObjects;
import com.easytradies.page.LoginPageObjects;
import com.easytradies.page.UploadImgObjects;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestUploadImg extends  Setup{

    UploadImgObjects UpImgObj;
    @BeforeClass
    public static void ClassInitialization()
    {
        Setup set = new Setup();
        set.InitDriverLive();

    }

    @AfterClass
    public  static void ClassCleanup()
    {
        driver.quit();
    }

    @Test
    public void Validate_Employee_Upload_Image()
    {
        driver.get("https://www.etprelive.com/sign-in-employee");
        LoginPageObjects login = new LoginPageObjects(driver);
        login.UserLogin("nayumih@me.com","test123");

        UpImgObj = new UploadImgObjects(driver);

        UpImgObj.ClickOnMyDetails();
        UpImgObj.UploadImage();
        String ExpectedResult = UpImgObj.GetUploadImgURL();
        String ActualData= "w.png";

        assertTrue(ExpectedResult.contains(ActualData));



    }

}
