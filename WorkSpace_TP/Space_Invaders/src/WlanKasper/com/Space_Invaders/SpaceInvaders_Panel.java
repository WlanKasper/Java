package WlanKasper.com.Space_Invaders;


import WlanKasper.com.Space_Invaders.Threads.Rocket_List;
import WlanKasper.com.Space_Invaders.Threads.SpaceShip_Alien;
import WlanKasper.com.Space_Invaders.Threads.SpaceShip_Battalion;
import WlanKasper.com.Space_Invaders.Threads.SpaceShip_Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.CyclicBarrier;

public class SpaceInvaders_Panel extends JPanel implements Runnable {

    // ---------- STATIC ----------
    private static final Dimension SCREEN_SIZE = new Dimension(SpaceInvaders_Frame.GAME_WIDTH, SpaceInvaders_Frame.GAME_HEIGHT);

    // ---------- Threads ----------
    Thread mainThread;
    SpaceShip_Player spaceShip_player;

    // ---------- Lists ----------
    SpaceShip_Battalion spaceShip_battalion;
    Rocket_List rocketList;

    // ---------- Graphics Objects ----------
    Image image;
    Graphics graphics;
    SpaceInvaders_Score spaceInvaders_score;

    public SpaceInvaders_Panel () {
        this.setFocusable(true);
        this.addKeyListener(new KeyListener());
        this.setPreferredSize(SCREEN_SIZE);

        spaceInvaders_score = new SpaceInvaders_Score(SpaceInvaders_Frame.GAME_WIDTH, SpaceInvaders_Frame.GAME_HEIGHT);
        spaceShip_battalion = new SpaceShip_Battalion();

        rocketList = new Rocket_List();
        mainThread = new Thread(this);
        mainThread.start();

        createNewSpaceShip_Player();
    }

    public void createNewSpaceShip_Player () {
        spaceShip_player = new SpaceShip_Player();
        spaceShip_player.start();
    }

    public void createNewSpaceShip_Rocket () {
        rocketList.addNewRocket(spaceShip_player.getSpaceShip());
    }

    @Override
    public void run () {
        while (true) {
            try {
                Thread.sleep(10);
                checkShots();
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public void paint (Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    public void draw (Graphics g) {
        spaceShip_player.drawSpaceShip(g);
        if (spaceShip_battalion.getSpaceShips() != null) {
            spaceShip_battalion.draw(g);
        }
        if (rocketList != null) {
            rocketList.draw(g);
        }
        spaceInvaders_score.draw(g);
        Toolkit.getDefaultToolkit().sync();
    }

    public void checkShots () {
        SpaceShip_Alien temp = rocketList.isShot(spaceShip_battalion.getSpaceShips());
        if (rocketList != null && temp != null) {
            spaceInvaders_score.player++;
        }
    }

    class KeyListener extends KeyAdapter {
        @Override
        public void keyPressed (KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_A) {
                spaceShip_player.pressedLeft();
            }
            if (e.getKeyCode() == KeyEvent.VK_D) {
                spaceShip_player.pressedRight();
            }
            if (e.getKeyCode() == KeyEvent.VK_W) {
                createNewSpaceShip_Rocket();
            }
        }

        @Override
        public void keyReleased (KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_A) {
                spaceShip_player.releasedLeft();
            }
            if (e.getKeyCode() == KeyEvent.VK_D) {
                spaceShip_player.releasedRight();
            }
        }
    }
}


