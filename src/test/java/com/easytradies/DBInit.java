package com.easytradies;
import com.mongodb.*;
import com.mongodb.client.MongoDatabase;


import java.util.Arrays;


public class DBInit {

    public void Updatecontractor(){

        MongoClient client = new MongoClient(new MongoClientURI("mongodb://easy_admin:test1234@ds153851.mlab.com:53851"));
        DB database = client.getDB("etv2live");
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
