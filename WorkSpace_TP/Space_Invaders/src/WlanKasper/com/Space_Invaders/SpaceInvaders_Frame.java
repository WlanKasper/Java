package WlanKasper.com.Space_Invaders;

import javax.swing.*;
import java.awt.*;

public class SpaceInvaders_Frame extends JFrame {

    public static final int GAME_WIDTH = 1000;
    public static final int GAME_HEIGHT = 700;

    SpaceInvaders_Panel spaceInvaders_Panel;

    SpaceInvaders_Frame () {
        spaceInvaders_Panel = new SpaceInvaders_Panel();
        this.add(spaceInvaders_Panel);
        this.setTitle("Space Invaders");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
