/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PQC
 */
public class DatabaseHelper {
     private static final Connection con=buildConnection();
     private static Connection  buildConnection()
     {
      Connection con1;
      try {
            String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // MySQL MM JDBC driver
            Class.forName(driverName);

            // Create a connection to the database
            String serverName = "localhost:1433";
            String mydatabase = "OnlineSale";
            String url = "jdbc:sqlserver://" + serverName +  ";databaseName=" + mydatabase; // a JDBC url
            String username = "sa";
            String password = "123456";
            con1 = DriverManager.getConnection(url, username, password);
           
        } 
      catch (ClassNotFoundException | SQLException ex) {
            con1=null;
            System.err.println("Initial connection failed:" + ex);
            throw new ExceptionInInitializerError(ex);
        }
      return con1;
    }
 
   public static Connection getConnection() {
       return con;
    }
}
