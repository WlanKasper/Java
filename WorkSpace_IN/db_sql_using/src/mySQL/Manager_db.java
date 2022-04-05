package mySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Manager_db {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc.mysql://localhost:3306/ricette";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";

    public static Manager_db instance = null;

    private Manager_db() {
        loadDriver();
    }

    public static Manager_db getInstance() {
        if (instance == null)
            instance = new Manager_db();
        return instance;
    }

    private void loadDriver() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection openConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    }

    public void closeConnection(Connection connection) {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
