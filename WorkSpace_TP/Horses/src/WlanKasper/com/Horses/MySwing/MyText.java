package WlanKasper.com.Horses.MySwing;

import javax.swing.*;
import java.awt.*;

public class MyText extends JTextField {

    public MyText(String str){
        this.setText(str);
        this.setBounds(CENTER, CENTER, CENTER, CENTER);
        this.setSelectedTextColor(Color.BLACK);

    }

    public void changeText(String str){
        this.setText(str);
    }

}
