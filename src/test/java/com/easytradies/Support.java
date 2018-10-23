package com.easytradies;
import com.easytradies.page.ContractorSignUpObjects;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;


public class Support  extends  Setup{

    ContractorSignUpObjects CSingnUpObj;

    public void verifyEmail(String email){
        driver.get("https://www.mailinator.com");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CSingnUpObj = new ContractorSignUpObjects(driver);
        CSingnUpObj.inboxfield.sendKeys(email);
        CSingnUpObj.go.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> elm = CSingnUpObj.Emailtable.findElements(By.tagName("tr"));
        elm.get(1).click();
        //CSingnUpObj.emailList.get(3).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // CSingnUpObj2 = new ContractorSignUpObjects(driver);

        driver.switchTo().frame("msg_body");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String EmailURL = (CSingnUpObj.button_link.getAttribute("href"));

        driver.get(EmailURL);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String aa = CSingnUpObj.successTxt.getText();

    }


    public void Updatecontractor(){

        //MongoClient client = new MongoClient(new MongoClientURI("mongodb://admin:polkmn09@ds050869.mlab.com:50869"));
        MongoClientURI uri = new MongoClientURI("mongodb://admin:polkmn09@ds050869.mlab.com:50869");
        MongoClient cli = new MongoClient(uri);

        MongoClient mongoClient = new MongoClient();
        //MongoDatabase db = mongoClient.getDatabase("easytrades");
        DBCollection collection  = cli.getDB("easytrades").getCollection("reportedjobs");

        DBObject documnet = new BasicDBObject();


       // BasicDBObject basic1 = new BasicDBObject();
        documnet.put("_id", "1");
        //basic1.put("UserName_1", "23423");
       // basic1.put("FirstName", "Amaury");
      //  basic1.put("LastName", "Valdes");
        collection.insert( documnet);
        cli.close();

    }
}
