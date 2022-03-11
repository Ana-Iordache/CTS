package com.company;

public interface DatabaseManager {
    void openConnection();

    void createEntity();

    void insertData();

    void readData();

    void closeConnection();

}
