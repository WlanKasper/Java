package dao.bin;

import util.ResultSetUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BeanRicetta {
    private int id;
    private String name;
    private String descrizione;

    //---------------------------------------------------------------------------------------------

    public static BeanRicetta create (ResultSet resultSet) throws SQLException {
        BeanRicetta beanRicetta = new BeanRicetta();

        beanRicetta.setId(ResultSetUtil._int(resultSet, "id", -1));
        beanRicetta.setName(ResultSetUtil._String(resultSet, "name"));
        beanRicetta.setDescrizione((ResultSetUtil._String(resultSet, "description")));
        return  beanRicetta;
    }

    //---------------------------------------------------------------------------------------------

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return "BeanRicetta{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descrizione='" + descrizione + '\'' +
                '}';
    }
}
