package wlankasper.com.carte.layout;

import java.util.Scanner;

public class Console {

    public Console () {
        boolean isCorrect = false;

        outParsedString("Welcome to 7.5 card game!\n\nPlease choice deck type: ");
        outNotParsedString("Italian~Russian"); // заменить

        do {
            switch (inString()) {
                case "Russian" -> {
                    outParsedString("ВЫВОД РУССКОЙ БУДЕТ ТУТ"); // заменить
                    isCorrect = true;
                }
                case "Italian" -> {
                    outParsedString("ВЫВОД ИТАЛЬЯНСКОЙ БУДЕТ ТУТ"); // заменить
                    isCorrect = true;
                }
                default -> {
                    outParsedString("Inputs error! Please retry");
                }
            }
        }
        while (!isCorrect);
    }

    public void outParsedString(String s) {
        System.out.println(s);
    }

    public void outNotParsedString(String s) {
        for (String value : s.split("~")) {
            System.out.println(value);
        }
    }

    public String inString () {
        return new Scanner(System.in).next();
    }
}
