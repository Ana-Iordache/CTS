package com.company;

public class Orchestrator {
    private DatabaseManager databaseManager;

    public Orchestrator(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    public void execute() {
        databaseManager.openConnection();
        databaseManager.createEntity();
        databaseManager.insertData();
        databaseManager.readData();
        databaseManager.closeConnection();
    }
}
