package wlankasper.com.pattern.strategy.algorithms;

public class SelectionSort extends AlgorithmsPattern {

    /*
  Complessità:
      Caso peggiore - O(n^2)
      Caso medio    - O(n^2)
      Miglior caso  - O(n^2)
   Memoria:
      Memoria - O(n)
   */

    public SelectionSort(double[] copyArray) {
        super(copyArray);
    }

    @Override
    public void sortArray() {
        for (int i = 0; i < copyArray.length; i++) {
            int pos = i;
            double min = copyArray[i];
            for (int j = i + 1; j < copyArray.length; j++) {
                if (copyArray[j] < min) {
                    pos = j;
                    min = copyArray[j];
                }
            }
            copyArray[pos] = copyArray[i];
            copyArray[i] = min;
        }
    }
}
