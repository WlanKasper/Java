package wlankasper.com.restaurant.objects.statics;

import wlankasper.com.restaurant.objects.StandardGraphicsObject;

import java.awt.*;
import java.util.ArrayList;

public class TableList {
    ArrayList<Table> tableList;

    public TableList() {
        tableList = new ArrayList<>();
    }

    public void draw(Graphics g) {
        if (!tableList.isEmpty()) {
            for (Table table : tableList) {
                table.draw(g);
            }
        }
    }

    public void addTable(Table table) {
        tableList.add(table);
    }

    public void intiTables() {
        int xPos = 0, yPos = 0;
        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0 -> {
                    xPos = 100;
                    yPos = 100;
                }
                case 3 -> {
                    xPos = 100;
                    yPos = 500;
                }
                default -> {
                    xPos += 250;
                }
            }
            Table table = new Table(xPos, yPos, i);
            addTable(table);
        }
    }

    public ArrayList<Table> getTableList() {
        return tableList;
    }

    public Table getTable(int id) {
        return tableList.get(id);
    }

    static class Table extends StandardGraphicsObject {

        public static int WIDTH = 100;
        public static int HEIGHT = 100;

        public Table(int x, int y, int id) {
            super(x, y, WIDTH, HEIGHT, id);
        }

        @Override
        public void draw(Graphics g) {
            g.setColor(Color.black);
            g.fillRect(x, y, width, height);

            g.setColor(Color.white);
            g.setFont(new Font("Consolas", Font.PLAIN, 10));
            g.drawString(String.valueOf(id), x + (WIDTH / 2), y + (HEIGHT / 2));
        }
    }
}

