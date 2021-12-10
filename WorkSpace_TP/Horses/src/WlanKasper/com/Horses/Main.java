package WlanKasper.com.Horses;

import WlanKasper.com.Horses.MySwing.*;
import WlanKasper.com.Horses.Threads.HorseThread;

public class Main {

    public static void main (String[] args) {

        String name0 = "VASYA", name1 = "IGOR", name2 = "LESHA", name3 = "LARA";

        MyFrame frame = new MyFrame();

//----------------HORSES--------------
        MyLabel label_0 = new MyLabel(name0);
        label_0.setImageHorse();
        label_0.setHorsePosition();
        MyLabel label_1 = new MyLabel(name1);
        label_1.setImageHorse();
        label_1.setHorsePosition();
        MyLabel label_2 = new MyLabel(name2);
        label_2.setImageHorse();
        label_2.setHorsePosition();
        MyLabel label_3 = new MyLabel(name3);
        label_3.setImageHorse();
        label_3.setHorsePosition();
        MyLabel label_4_text = new MyLabel("First horse: ");
        label_4_text.setPosition();
//----------------HORSES--------------
        MyText firstHorseText = new MyText("First horse: ");
        MyButton button = new MyButton("Restart");

        MyPanel panel_0 = new MyPanel(0, 0,   frame.getWidth(), label_0.getHeight());
        MyPanel panel_1 = new MyPanel(0, 155, frame.getWidth(), label_1.getHeight());
        MyPanel panel_2 = new MyPanel(0, 310, frame.getWidth(), label_2.getHeight());
        MyPanel panel_3 = new MyPanel(0, 465, frame.getWidth(), label_3.getHeight());
        MyPanel panel_4_text = new MyPanel(500, 650, 250, 100);
        MyPanel panel_5_button = new MyPanel(800, 650, 200, 100);

        panel_0.add(label_0);
        panel_1.add(label_1);
        panel_2.add(label_2);
        panel_3.add(label_3);
        panel_4_text.add(label_4_text);
        panel_5_button.add(button);

        frame.add(panel_0);
        frame.add(panel_1);
        frame.add(panel_2);
        frame.add(panel_3);
        frame.add(panel_4_text);
        frame.add(panel_5_button);

        HorseThread thread_0 = new HorseThread(name0, label_0);
        HorseThread thread_1 = new HorseThread(name1, label_1);
        HorseThread thread_2 = new HorseThread(name2, label_2);
        HorseThread thread_3 = new HorseThread(name3, label_3);

        thread_0.start();
        thread_1.start();
        thread_2.start();
        thread_3.start();

        frame.setVisible(true);

        while (true){
            if (!thread_0.isAlive()){
                label_4_text.changeText("First horse: " + thread_0.horseName());
                break;
            }
            else if (!thread_1.isAlive()){
                label_4_text.changeText("First horse: " + thread_1.horseName());
                break;
            }
            else if (!thread_2.isAlive()){
                label_4_text.changeText("First horse: " + thread_2.horseName());
                break;
            }
            else if (!thread_3.isAlive()){
                label_4_text.changeText("First horse: " + thread_3.horseName());
                break;
            }
        }

        thread_0.interrupt();
        thread_1.interrupt();
        thread_2.interrupt();
        thread_3.interrupt();

    }
}