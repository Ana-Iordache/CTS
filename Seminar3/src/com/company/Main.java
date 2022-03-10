package com.company;

public class Main {
    public static void main(String[] args) {
        DatabaseService databaseService = new SqliteDb("jdbc:sqlite:database.db", "org.sqlite.JDBC");
        databaseService.createEntity();
        databaseService.insertData();
        databaseService.readData();
        databaseService.closeConnection();

        databaseService = new MongoDb("localhost", 27017, "test");
        databaseService.createEntity();
        databaseService.insertData();
        databaseService.readData();
        databaseService.closeConnection();
    }
}
