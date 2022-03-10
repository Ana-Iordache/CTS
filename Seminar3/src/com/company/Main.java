package com.company;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args){
        SqlDatabaseService sqlDatabaseService = new SqlDatabaseService();
        try {
            sqlDatabaseService.initializeConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        NoSqlDatabaseService noSqlDatabaseService = new NoSqlDatabaseService();
        noSqlDatabaseService.initializeConnection();
        noSqlDatabaseService.createCollection();
        noSqlDatabaseService.insertData();
        noSqlDatabaseService.readData();
        noSqlDatabaseService.closeConnection();
    }
}
