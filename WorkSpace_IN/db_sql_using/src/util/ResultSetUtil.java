package util;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetUtil {

    public static int _int(ResultSet resultSet, String fieldName) {
        return _int(resultSet, fieldName, 0);
    }
    public static int _int(ResultSet resultSet, String fieldName, int defValue) {
        try {
            return resultSet.getInt(fieldName);
        } catch (SQLException e) {
            e.printStackTrace();
            return defValue;
        }
    }

    public static String _String(ResultSet resultSet, String fieldName) {
        return _String(resultSet, fieldName, null);
    }
    public static String _String(ResultSet resultSet, String fieldName, String defValue) {
        try {
            return resultSet.getString(fieldName);
        } catch (SQLException e) {
            e.printStackTrace();
            return defValue;
        }
    }
}
