/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class connectDB {
    
    public static Connection connectSQLServer() throws ClassNotFoundException, SQLException{
    
        final String JDBC_DRIVER =  "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        final String DB_URL = "jdbc:sqlserver://localhost;";
        final String DATABASENAME = "databaseName=QuanLyPhongGym;";
        final String USER = "user=sa;";
        final String PASS = "password =thuannguyen";
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DB_URL + DATABASENAME + USER + PASS);
        return connection;
    }
    
}