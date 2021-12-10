package WlanKasper.com.Horses.MySwing;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    public static final int WIDTH_FRAME = 1201;
    public static final int HEIGHT_FRAME = 900;

    public MyFrame(){
        this.setTitle("Cavalli GUI");
        this.getContentPane().setBackground(Color.WHITE);
        this.setSize(WIDTH_FRAME, HEIGHT_FRAME);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
