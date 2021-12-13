package WlanKasper.com.Space_Invaders.Threads;

import WlanKasper.com.Space_Invaders.Objects.Rocket;
import WlanKasper.com.Space_Invaders.Objects.SpaceShip;
import WlanKasper.com.Space_Invaders.SpaceInvaders_Frame;

import java.awt.*;
import java.util.ArrayList;

public class Rocket_List {

    private final ArrayList<SpaceShip_Rocket> rocketListPlayer;
    private final ArrayList<SpaceShip_Rocket> rocketListAlien;

    public Rocket_List () {
        rocketListPlayer = new ArrayList<>();
        rocketListAlien = new ArrayList<>();
    }

    public void addNewPlayerRocket (SpaceShip spaceShip){
        SpaceShip_Rocket rocket = new SpaceShip_Rocket(spaceShip);
        rocket.setDirection(-10);
        rocket.start();
        rocketListPlayer.add(rocket);
    }

    public void addNewAlienRocket (SpaceShip spaceShip){
        SpaceShip_Rocket rocket = new SpaceShip_Rocket(spaceShip);
        rocket.setDirection(10);
        rocket.start();
        rocketListAlien.add(rocket);
    }

    public void draw(Graphics g){
        for (SpaceShip_Rocket elem: rocketListPlayer) {
            elem.drawRocket(g);
        }
        for (SpaceShip_Rocket elem: rocketListAlien) {
            elem.drawRocket(g);
        }
    }

    public SpaceShip_Alien isShotAlien (ArrayList<SpaceShip_Alien> shipList) {
        for (SpaceShip_Alien alien: shipList) {
            for (SpaceShip_Rocket rocket: rocketListPlayer) {
                if (rocket.getRocket().intersects(alien.getSpaceShip())) {
                    alien.interrupt();
                    shipList.remove(alien);

                    rocket.interrupt();
                    rocketListPlayer.remove(rocket);
                    return alien;
                }
            }
        }
        return null;
    }

    public SpaceShip_Player isShotPlayer (SpaceShip_Player ship) {
        for (SpaceShip_Rocket rocket: rocketListAlien) {
            if (rocket.getRocket().intersects(ship.getSpaceShip())) {

                rocket.interrupt();
                rocketListAlien.remove(rocket);
                return ship;
            }
        }
        return null;
    }


    static class SpaceShip_Rocket extends Thread {
        private final Rocket rocket;

        public SpaceShip_Rocket (SpaceShip spaceShip) {
            rocket = new Rocket(spaceShip.x - (Rocket.ROCKET_DIAMETER / 2), spaceShip.y - Rocket.ROCKET_DIAMETER);
        }

        public void setDirection (int direct){
            rocket.setYDirection(direct);
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
            if (rocket.y < 0 || rocket.y > SpaceInvaders_Frame.GAME_HEIGHT) {
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




