/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shiyq.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Date;
import org.bson.Document;

/**
 *
 * @author flysy
 */
public class InsertThread extends Thread {

    private String code;
    private String name;
    private String password;

    public InsertThread(String code, String name, String password) {
        this.code = code;
        this.name = name;
        this.password = password;
    }

    @Override
    public void run() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("study");

        MongoCollection<Document> collection = mongoDatabase.getCollection("s_user");
        Document document;
        while (true) {
            document = new Document();
            document.append("code", code);
            document.append("name", name);
            document.append("password", password);
            document.append("create_date", new Date());

            collection.insertOne(document);
        }
    }
}
