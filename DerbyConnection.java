package department.mangement;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DerbyConnection {

    Connection connection;
    Statement statement;
    String driverName, sourceURL, user, password, host, database;

    public DerbyConnection() {

        driverName = "com.mysql.jdbc.Driver";
       // sourceURL = "jdbc:mysql://www.tutorsbangladesh.com:2083/tutorsba_tution";
       // user = "tutorsba";
       // password = "fuck&hack1234ffae11";
        sourceURL = "jdbc:mysql://localhost/ictworld";
        user = "root";
        password = "";
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(sourceURL, user, password);
        } catch ( ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }
    public static void main(String[] args) {
        new DerbyConnection();
    }
}
