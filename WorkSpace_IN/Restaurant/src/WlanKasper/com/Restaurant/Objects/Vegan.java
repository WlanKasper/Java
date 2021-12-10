package WlanKasper.com.Restaurant.Objects;

import java.awt.*;

public class Vegan extends Client {

    private static final String menu = "1) Baida Roti. Baida roti is an Indian bread with the goodness of eggs.\n" + "2) Chicken Biryani. Chicken Biryani is a super traditional dish that never goes out of fashion.\n" + "3) Keema Pao.\n" + "4) Garlic Mustard Fish Fillet.\n" + "5) Bheja Fry.\n" + "6) Kebabs.\n" + "7) Phuket Chicken Biryani.\n" + "8) Butter Chicken.";

    public Vegan (int x, int y, String name, int id) {
        super(x, y, name, id);
    }

    @Override
    public void draw (Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, width, height);
    }

    public static String getMenu () {
        return menu;
    }
}
