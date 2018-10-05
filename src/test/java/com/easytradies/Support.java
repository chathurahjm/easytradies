package com.easytradies;
import com.mongodb.*;
import com.mongodb.client.MongoDatabase;
import org.testng.annotations.Test;


import java.util.Arrays;


public class Support {

    @Test
    public void Updatecontractor(){

        MongoClient client = new MongoClient(new MongoClientURI("mongodb://admin:polkmn09@ds050869.mlab.com:50869"));
        DB database = client.getDB("easytrades");
        DBCollection collection = database.getCollection("employees");

        // Created with Studio 3T, the IDE for MongoDB - https://studio3t.com/

        BasicDBObject query = new BasicDBObject();
        query.put("FirstName", "TestContractor1");

        Cursor cursor = collection.find(query);
        while (cursor.hasNext()) {
            BasicDBObject document = (BasicDBObject) cursor.next();
            System.out.println(document.toString());
        }

        client.close();

    }
}
