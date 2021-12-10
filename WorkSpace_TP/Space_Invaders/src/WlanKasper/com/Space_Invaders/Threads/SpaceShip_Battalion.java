package WlanKasper.com.Space_Invaders.Threads;

import WlanKasper.com.Space_Invaders.Objects.SpaceShip;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CyclicBarrier;

public class SpaceShip_Battalion {
    private ArrayList<SpaceShip_Alien> battalion;
    private final CyclicBarrier gate = new CyclicBarrier(27);

    public SpaceShip_Battalion () {
        battalion = new ArrayList<>();
        createBattalion();
    }

    public void addNewSpaceShip_Alien (SpaceShip_Alien ship) {
        battalion.add(ship);
    }

    public void createBattalion () {
        int x = 0, y = 0;
        int id = 0;
        for (int i = 0; i < 27; i++) {

            if (i % 9 == 0) {
                x = 10;
                y += SpaceShip.SPACESHIP_HEIGHT + 10;
                id++;
            } else {
                x += SpaceShip.SPACESHIP_WIDTH + 50;
            }

            SpaceShip_Alien spaceShip_alien = new SpaceShip_Alien(x, y, id,this, gate);
            spaceShip_alien.start();
            addNewSpaceShip_Alien(spaceShip_alien);
        }
    }

    public void draw (Graphics g) {
        for (SpaceShip_Alien ship : battalion) {
            ship.drawSpaceShip(g);
        }
    }

    public ArrayList<SpaceShip_Alien> getSpaceShips () {
        if (battalion.isEmpty()) {
            return null;
        } else {
            return battalion;
        }
    }

    public void killSpaceShip (SpaceShip_Alien ship) {
        ship.interrupt();
        battalion.remove(ship);
    }

    public void moveAllDown () {
        for (SpaceShip_Alien ship : battalion) {
            ship.getSpaceShip().setXDirection(ship.getSpaceShip().xVelocity * -1);
            ship.getSpaceShip().moveDown();
        }
    }

}
