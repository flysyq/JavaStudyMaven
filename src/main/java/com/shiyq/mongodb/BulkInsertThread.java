/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shiyq.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.bson.Document;

/**
 *
 * @author flysy
 */
public class BulkInsertThread extends Thread {

    private String code;
    private String name;
    private String password;

    public BulkInsertThread(String code, String name, String password) {
        this.code = code;
        this.name = name;
        this.password = password;
    }

    @Override
    public void run() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("study");

        MongoCollection<Document> collection = mongoDatabase.getCollection("s_user");
        List<Document> list = new ArrayList<>();
        Document document;

        int i = 0;
        while (true) {
            if (i++ < 1000) {
                document = new Document();
                document.append("id", UUID.randomUUID());
                document.append("code", code);
                document.append("name", name);
                document.append("password", password);
                document.append("create_date", new Date());
                list.add(document);
            } else {
                //System.out.println(list.size());
                collection.insertMany(list);
                list.clear();
                i = 0;
            }
        }
    }
}
