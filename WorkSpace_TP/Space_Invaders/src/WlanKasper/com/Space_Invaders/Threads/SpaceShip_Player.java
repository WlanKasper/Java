package WlanKasper.com.Space_Invaders.Threads;


import WlanKasper.com.Space_Invaders.Objects.SpaceShip;
import WlanKasper.com.Space_Invaders.SpaceInvaders_Frame;

import java.awt.*;

public class SpaceShip_Player extends Thread {

    private final SpaceShip spaceShip;

    public SpaceShip_Player () {
        spaceShip = new SpaceShip(SpaceInvaders_Frame.GAME_WIDTH / 2, SpaceInvaders_Frame.GAME_HEIGHT - SpaceShip.SPACESHIP_HEIGHT, 0);
    }

    @Override
    public void run () {
        super.run();
        while (true) {
            try {
                Thread.sleep(10);
                checkBoards();
                spaceShip.move();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public void drawSpaceShip (Graphics g) {
        spaceShip.draw(g);
    }

    public void pressedLeft () {
        spaceShip.setXDirection(-10);
    }

    public void pressedRight () {
        spaceShip.setXDirection(10);
    }

    public void releasedLeft () {
        spaceShip.setXDirection(-0);
    }

    public void releasedRight () {
        spaceShip.setXDirection(0);
    }

    public void checkBoards () {
        if (spaceShip.x < 0) {
            spaceShip.x = 0;
        }
        if (spaceShip.x > SpaceInvaders_Frame.GAME_WIDTH - SpaceShip.SPACESHIP_WIDTH) {
            spaceShip.x = SpaceInvaders_Frame.GAME_WIDTH - SpaceShip.SPACESHIP_WIDTH;
        }
    }

    public SpaceShip getSpaceShip () {
        return spaceShip;
    }
}
