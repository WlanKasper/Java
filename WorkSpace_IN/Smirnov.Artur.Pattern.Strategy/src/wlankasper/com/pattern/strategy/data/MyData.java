package wlankasper.com.pattern.strategy.data;

import java.util.ArrayList;

public class MyData {

    private final ArrayList<Double> myArray;

    public MyData() {
        myArray = new ArrayList<>();
    }

    public void addElement (double number) {
        myArray.add(number);
    }

    public double[] getArray () {
        int size = myArray.size();
        double[] tempArray = new double[size];
        for (int i = 0; i < size; i++) {
            tempArray[i] = myArray.get(i);
        }

        return tempArray;
    }

    @Override
    public String toString() {
        return  "{ Data = " + myArray + " }";
    }
}
