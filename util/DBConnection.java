package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/hostel_db";
    private static final String USER = "root";     // change if your MySQL user is different
    private static final String PASSWORD = "Nazeer786@";     // change if your MySQL password is set

    public static Connection getConnection() throws Exception {
        // Load driver (optional for modern JDBC but safe)
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
