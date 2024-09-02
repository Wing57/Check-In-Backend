package com.introbotics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.sqlite.SQLiteException;

public class DatabaseConnections {
    
    private static final String URL = "jdbc:sqlite::resource:testDB.db";

    public static Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL);
            System.out.println("Succesful connection to database");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return connection;
    }
}
