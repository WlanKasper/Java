package wlankasper.com.pattern.strategy;

import wlankasper.com.pattern.strategy.algorithms.QuickSort;
import wlankasper.com.pattern.strategy.algorithms.SelectionSort;
import wlankasper.com.pattern.strategy.data.MyData;

public class Main {
    public static void main(String[] args) {
        MyData data = new MyData();
        data.addElement(2);
        data.addElement(3);
        data.addElement(4);
        data.addElement(21);
        data.addElement(6);
        data.addElement(1);
        System.out.println(data.toString());

        QuickSort sort2 = new QuickSort(data.getArray());
        sort2.sortArray();
        System.out.println(sort2.toString());
;
//        SelectionSort sort1 = new SelectionSort(data.getArray());
//        sort1.sortArray();
//        System.out.println(sort1.toString());

    }
}
