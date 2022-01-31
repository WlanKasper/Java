package wlankasper.com.pattern.strategy.algorithms;

import java.util.Arrays;

public abstract class AlgorithmsPattern {

    final double[] copyArray;

    public AlgorithmsPattern (double[] copyArray){
        this.copyArray = copyArray;
    }

    abstract public void sortArray ();

    @Override
    public String toString() {
        return "{ Sorted Array = " + Arrays.toString(copyArray) + " }";
    }
}
