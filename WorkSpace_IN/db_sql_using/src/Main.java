import mySQL.Manager_db;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Manager_db manager_db = Manager_db.getInstance();
        Connection connection = null;
        try {
            connection = manager_db.openConnection();


            manager_db.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
