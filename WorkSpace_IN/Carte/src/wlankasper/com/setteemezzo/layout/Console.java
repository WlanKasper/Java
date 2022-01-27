package wlankasper.com.setteemezzo.layout;

import java.util.Scanner;

public class Console {

    public void outputString (String s) {
        System.out.println(s);
    }

    public String inputString(){
        return new Scanner(System.in).next();
    }
}
