package com.company;

public class Main {
    public static void main(String[] args) throws Exception {

        DatabaseManager databaseManager;
        databaseManager = (DatabaseManager) Class.forName("com.company.SqliteDb")
                .getDeclaredConstructor(String.class)
                .newInstance("jdbc:sqlite:database.db");

        Orchestrator orchestrator;
        orchestrator = new Orchestrator(databaseManager);
        orchestrator.execute();

        databaseManager = (DatabaseManager) Class.forName("com.company.MongoDb")
                .getDeclaredConstructor(String.class, Integer.TYPE, String.class)
                .newInstance("localhost", 27017, "test");
        orchestrator = new Orchestrator(databaseManager);
        orchestrator.execute();
    }
}
