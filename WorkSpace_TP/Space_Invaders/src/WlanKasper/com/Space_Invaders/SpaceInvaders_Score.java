package WlanKasper.com.Space_Invaders;

import java.awt.*;

public class SpaceInvaders_Score extends Rectangle {

    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    int player;
    int computer;
    int isRunning = 1;

    SpaceInvaders_Score (int GAME_WIDTH, int GAME_HEIGHT) {
        SpaceInvaders_Score.GAME_WIDTH = GAME_WIDTH;
        SpaceInvaders_Score.GAME_HEIGHT = GAME_HEIGHT;
    }

    public void draw (Graphics g) {
        if (isRunning == 1){
            g.setColor(Color.white);
            g.setFont(new Font("Consolas", Font.PLAIN, 60));
            g.drawLine(0, (int) (GAME_HEIGHT / 1.5), GAME_WIDTH, (int) (GAME_HEIGHT / 1.5));
            g.drawString(computer / 10 + String.valueOf(computer % 10), 0, ((int) (GAME_HEIGHT / 1.5)) - 5);
            g.drawString(player / 10 + String.valueOf(player % 10), 0, ((int) (GAME_HEIGHT / 1.5)) + 50);
        }else if (isRunning == 0){
            g.setColor(Color.red);
            g.setFont(new Font("Consolas", Font.PLAIN, 80));
            g.drawString( "GAME OVER", GAME_WIDTH / 2, GAME_HEIGHT / 2);
        } else if (isRunning == 2){
            g.setColor(Color.green);
            g.setFont(new Font("Consolas", Font.PLAIN, 80));
            g.drawString( "VICTORY", GAME_WIDTH / 2, GAME_HEIGHT / 2);
        }


    }
}