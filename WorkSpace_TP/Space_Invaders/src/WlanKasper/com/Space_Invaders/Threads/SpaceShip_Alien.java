package WlanKasper.com.Space_Invaders.Threads;

import WlanKasper.com.Space_Invaders.Objects.SpaceShip;
import WlanKasper.com.Space_Invaders.SpaceInvaders_Frame;

import java.awt.*;

public class SpaceShip_Alien extends Thread {

    private final SpaceShip spaceShip;
    private final SpaceShip_Battalion battalion;


    public SpaceShip_Alien (int x, int y, int id, SpaceShip_Battalion battalion) {
        this.battalion = battalion;
        spaceShip = new SpaceShip(x, y, id);
        spaceShip.setXDirection(1);
    }

    @Override
    public void run () {
        super.run();

        while (true) {
            try {
                Thread.sleep(10);
                spaceShip.move();
                checkBoards();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public void drawSpaceShip (Graphics g) {
        spaceShip.draw(g);
    }

    public void checkBoards () {
        if (spaceShip.x < 0 || spaceShip.x > SpaceInvaders_Frame.GAME_WIDTH - SpaceShip.SPACESHIP_WIDTH) {
            battalion.moveAllDown();
        }
    }

    public SpaceShip getSpaceShip () {
        return spaceShip;
    }
}
