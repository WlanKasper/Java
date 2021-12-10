package WlanKasper.com.Horses.MySwing;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    public MyPanel(int x, int y, int panelWidth, int panelHeight){
        this.setBackground(Color.GREEN);
        this.setLayout(new BorderLayout());
        this.setBounds(x, y, panelWidth, panelHeight);
    }
}
