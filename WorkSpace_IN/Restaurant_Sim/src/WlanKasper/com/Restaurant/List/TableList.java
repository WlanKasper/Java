package WlanKasper.com.Restaurant.List;

import java.util.ArrayList;
import WlanKasper.com.Restaurant.Objects.Table;
import java.awt.*;

public class TableList {
    ArrayList<Table> tableList;

    public TableList () {
        tableList = new ArrayList<>();
    }

    public void draw(Graphics g){
        if (!tableList.isEmpty()){
            for (Table table: tableList) {
                table.draw(g);
            }
        }
    }

    public void addTabele (Table table){
        tableList.add(table);
    }

    public void intiTables () {
        int xPos = 0, yPos = 0;
        for (int i = 0; i < 6; i++) {
            switch(i) {
                case 0: {
                    xPos = 100;
                    yPos = 100;
                    break;
                }
                case 3: {
                    xPos = 100;
                    yPos = 500;
                    break;
                }
                default: {
                    xPos += 250;
                    break;
                }
            }
            Table table = new Table(xPos, yPos, i);
            addTabele(table);
        }
    }

    public ArrayList<Table> getTableList() {
        return tableList;
    }

    public Table getTable (int id) {
        return tableList.get(id);
    }
}