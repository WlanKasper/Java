package wlankasper.com.restaurant.objects;

import java.awt.*;
import java.util.ArrayList;

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

    public class Table extends Rectangle {
        public static final int WIDTH = 100;
        public static final int HEIGHT = 100;

        private final int id;

        public Table (int xPos, int yPos, int id) {
            super(xPos, yPos, WIDTH, HEIGHT);
            this.id = id;
        }

        public void draw (Graphics g) {
            g.setColor(Color.black);
            g.fillRect(x, y, width, height);

            g.setColor(Color.white);
            g.setFont(new Font("Consolas", Font.PLAIN, 10));
            g.drawString(String.valueOf(id), x + (WIDTH / 2), y + (HEIGHT / 2));
        }


        public int getId() {
            return id;
        }
    }

}
