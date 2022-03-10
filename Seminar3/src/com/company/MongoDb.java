package com.company;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDb implements DatabaseService {
    MongoDatabase mongoDb;
    MongoClient mongoClient;

    public MongoDb(String host, int port, String databaseName) {
        mongoClient = new MongoClient(host, port);
        mongoDb = mongoClient.getDatabase(databaseName);
    }

    @Override
    public void createEntity() {
        if (mongoDb.getCollection("employees") != null) {
            mongoDb.getCollection("employees").drop();
        }
        mongoDb.createCollection("employees");
    }

    @Override
    public void insertData() {
        Document employee1 = new Document().append("name", "Popescu Ion").
                append("address", "Bucharest").append("salary", 4000);

        MongoCollection<Document> collection = mongoDb.getCollection("employees");
        collection.insertOne(employee1);

        Document employee2 = new Document().append("name", "Ionescu Vasile").
                append("salary", 4500);
        collection.insertOne(employee2);
    }

    @Override
    public void readData() {
        FindIterable<Document> result = mongoDb.getCollection("employees").find();
        for (Document doc : result) {
            System.out.println(doc);
        }
    }

    @Override
    public void closeConnection() {
        mongoClient.close();
    }
}
