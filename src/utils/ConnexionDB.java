package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionDB {
    private static String url = "jdbc:mysql://localhost:3306/DameDB";
    private static String user = "root";
    private static String password = "";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver MySQL non trouvé.", e);
        }

        return DriverManager.getConnection(url, user, password);
    }
}
