package wlankasper.com.pattern.strategy.algorithms;

import java.util.Arrays;

public abstract class AlgorithmsPattern {

//    https://academy.yandex.ru/posts/osnovnye-vidy-sortirovok-i-primery-ikh-realizatsii

    final double[] copyArray;
    String name;

    public AlgorithmsPattern(double[] copyArray, String name) {
        this.copyArray = copyArray;
        this.name = name;
    }

    abstract public void sortArray();

    @Override
    public String toString() {
        return "{ Array Sorted by " + name + " = " + Arrays.toString(copyArray) + " }";
    }
}
