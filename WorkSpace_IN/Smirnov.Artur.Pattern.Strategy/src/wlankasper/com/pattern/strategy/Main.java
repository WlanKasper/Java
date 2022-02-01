package wlankasper.com.pattern.strategy;

import wlankasper.com.pattern.strategy.algorithms.AlgorithmsPattern;
import wlankasper.com.pattern.strategy.algorithms.QuickSort;
import wlankasper.com.pattern.strategy.algorithms.SelectionSort;
import wlankasper.com.pattern.strategy.data.MyData;
import wlankasper.com.pattern.strategy.layout.Console;

public class Main {

    public static void main(String[] args) {

        Console console = new Console();
        MyData data = new MyData();
        AlgorithmsPattern algorithm;

        console.outputString("Welcome to Patter-Strategy created by @WlanKasper");
        console.outputString("Choose what is more important for you:\n[1] Use less memory\n[2] Speed of operation");
        String choice = console.inputString();

        console.outputString("Okay, now you need to enter the size of the array, which will be filled with random numbers.");
        int size = console.inputInteger();

        data.addNRandomElements(size);
        console.outputString(data.toString());

        switch (choice){
            case "1":
                algorithm = new QuickSort(data.getArray());
                break;
            case "2":
                algorithm = new SelectionSort(data.getArray());
                break;
            default:
                console.outputString("---Error input---");
                return;
        }

        algorithm.sortArray();
        console.outputString("Okay, here is our result: " + algorithm.toString());
    }
}