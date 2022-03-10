package com.company;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class NoSqlDatabaseService {
    MongoDatabase mongoDb;
    MongoClient mongoClient;

    public void initializeConnection() {
        mongoClient = new MongoClient("localhost", 27017);
        mongoDb = mongoClient.getDatabase("test");
    }

    public void createCollection() {
        if (mongoDb.getCollection("employees") != null) {
            mongoDb.getCollection("employees").drop();
        }

        mongoDb.createCollection("employees");
    }

    public void insertData(){
        Document employee1 = new Document().append("name", "Popescu Ion").
                append("address", "Bucharest").append("salary", 4000);

        MongoCollection<Document> collection = mongoDb.getCollection("employees");
        collection.insertOne(employee1);

        Document employee2 = new Document().append("name", "Ionescu Vasile").
                append("salary", 4500);
        collection.insertOne(employee2);
    }

    public void readData(){
        FindIterable<Document> result = mongoDb.getCollection("employees").find();
        for (Document doc : result) {
            System.out.println(doc);
        }
    }

    public void closeConnection(){
        mongoClient.close();
    }
}
