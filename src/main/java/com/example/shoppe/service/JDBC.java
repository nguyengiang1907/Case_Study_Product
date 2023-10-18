package com.example.shoppe.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
    private String connectUrl = "jdbc:mysql://localhost:3306/shoppe";
    private String userName = "root";
    private String passWord = "giang";


    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(connectUrl, userName, passWord);
        return connection;
    }
}
