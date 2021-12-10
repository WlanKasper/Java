package WlanKasper.com.Space_Invaders.Threads;

import WlanKasper.com.Space_Invaders.Objects.Rocket;
import WlanKasper.com.Space_Invaders.Objects.SpaceShip;

import java.awt.*;
import java.util.ArrayList;

public class Rocket_List {

    private ArrayList<SpaceShip_Rocket> rocketList;
    private SpaceShip_Rocket rocket;

    public Rocket_List () {
        rocketList = new ArrayList<>();
    }

    public void addNewRocket(SpaceShip spaceShip){
        rocket = new SpaceShip_Rocket(spaceShip);
        rocket.start();
        rocketList.add(rocket);
    }

    public void draw(Graphics g){
        for (SpaceShip_Rocket elem: rocketList) {
            elem.drawRocket(g);
        }
    }

    public SpaceShip_Alien isShot (ArrayList<SpaceShip_Alien> shipList) {
        for (SpaceShip_Alien alien: shipList) {
            for (SpaceShip_Rocket rocket: rocketList) {
                if (rocket.getRocket().intersects(alien.getSpaceShip())) {
                    alien.interrupt();
                    shipList.remove(alien);

                    rocket.interrupt();
                    rocketList.remove(rocket);
                    return alien;
                }
            }
        }
        return null;
    }


    class SpaceShip_Rocket extends Thread {
        private final Rocket rocket;

        public SpaceShip_Rocket (SpaceShip spaceShip) {
            rocket = new Rocket(spaceShip.x - (Rocket.ROCKET_DIAMETER / 2), spaceShip.y - Rocket.ROCKET_DIAMETER);
            rocket.setYDirection(-10);
        }

        @Override
        public void run () {
            super.run();
            while (true) {
                try {
                    Thread.sleep(10);
                    checkBoards();
                    moveRockets();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }

        public void moveRockets () {
            rocket.move();
        }

        public void checkBoards () {
            if (rocket.y < 0) {
                rocket.delete();
                this.interrupt();
            }
        }

        public void drawRocket (Graphics g) {
            rocket.draw(g);
        }

        public Rocket getRocket (){
            return rocket;
        }

    }

}




