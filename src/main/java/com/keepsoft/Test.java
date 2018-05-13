package com.keepsoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    private static Connection  conn;
    private static PreparedStatement stmt;
    public static Connection linktoSQLServer() {
       //String connect to SQL server
       String strServerIPAddress = "localhost";
       String strDatabaseName = "gaxqhmcs0404";
       String url = "jdbc:sqlserver://" + strServerIPAddress + ":1433" +
               ";DatabaseName=" + strDatabaseName;
       String strUserName = "sa";
       String strPassword = "123456";
       //Connection conn = null;
       try {
           //  Register the driver
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
           try {
               /* Get a connection to the database */
               conn = DriverManager.getConnection(url, strUserName, strPassword);
           } catch (SQLException ex) {
               System.out.println("Exception One:");
               ex.printStackTrace();
           }
       } catch (Exception ex) {
           System.out.println("Exception Two:");
           ex.printStackTrace();
       }
       System.out.println("Connected...");
       return conn;
   }
   public static void SQLServer_select() {
       //this code just for SQL Server
       try {
           String strCmd = "SELECT * FROM Production.Location";
          ResultSet rs = stmt.executeQuery(strCmd);
           while (rs.next()) {
               System.out.println("Column 1 has value: " + rs.getString(1));
               System.out.println("Column 2 has value: " + rs.getString(2));
               System.out.println("Column 3 has value: " + rs.getString(3));
           }
       } catch (SQLException ex) {
           System.out.println("SQLException: " + ex.getMessage());
           System.out.println("SQLState: " + ex.getSQLState());
           System.out.println("VendorError: " + ex.getErrorCode());
       }
   }
   public static void main(String[] args) {
	   linktoSQLServer();
   }
}
