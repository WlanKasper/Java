package WlanKasper.com.Horses.Threads;

import WlanKasper.com.Horses.MySwing.MyLabel;

public class HorseThread extends Thread{

    public static final int MAX_SPEED = 10;
    public static final int MID_SPEED = 5;
    public static final int MIN_SPEED = 1;

    private final String name;
    private final int speed;
    private int distance;

    MyLabel label;

    public HorseThread(String name, MyLabel label)
    {
        this.name = name;
        this.speed = (int) (1 + Math.random() * 100);
        this.label = label;
    }

    public void run()
    {
        for (distance = 0; distance < 105; distance++)
        {
            label.moveHorse();
            try
            {
                sleep(100L * speed/10);
            } catch (InterruptedException e)
            {
                break;
            }
        }
    }

    public String horseName()
    {
        return name;
    }

    public int horseGetDistance()
    {
        return distance;
    }

}
