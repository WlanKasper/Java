package dao;

import dao.bin.BeanRicetta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoRicetta {
    public static final String GET_LIST = "select id, name, ingredients, cost"
            + " from ricette";

    public static final String GET_ELEMENT_BY_ID = "select id, name, ingredients, cost"
            + " from ricette"
            + " where id = ???";

    //---------------------------------------------------------------------------------------------

    private final Connection connection;

    public DaoRicetta(Connection connection) {
        this.connection = connection;
    }

    //---------------------------------------------------------------------------------------------

    public BeanRicetta getElement(int idRicetta) {
        BeanRicetta beanRicetta = new BeanRicetta();
        // TODO: 01/04/22
        return null;
    }


    public List<BeanRicetta> getList() throws SQLException {
        List<BeanRicetta> list = null;
        PreparedStatement preparedStatement = null; // для вставки параметров в query
        ResultSet resultSet = null;

        if (connection != null) {
            preparedStatement = connection.prepareStatement(GET_LIST);
            resultSet = preparedStatement.executeQuery();

            if (resultSet != null) {
                list = new ArrayList<>();

                while (resultSet.next()) {
                    list.add(BeanRicetta.create(resultSet));
                }
            }
        }
        return list;
    }
}
