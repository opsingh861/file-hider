package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    public static Connection connection;
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cse406?useSSL=false","root","root");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Connected to database");
        return connection;
    }

    public static void closeConnection() {
       if (connection != null) {
           try {
               connection.close();
           }
           catch (SQLException e) {
               e.printStackTrace();
           }
       }
    }

    public static void main(String[] args) {
        MyConnection.getConnection();
    }
}
