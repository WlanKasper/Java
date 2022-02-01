package wlankasper.com.pattern.strategy.layout;

import java.util.Scanner;

public class Console {

    public void outputString (String str){
        System.out.println(str);
    }

    public String inputString (){
        return new Scanner(System.in).next();
    }

    public int inputInteger (){
        return new Scanner(System.in).nextInt();
    }
}
