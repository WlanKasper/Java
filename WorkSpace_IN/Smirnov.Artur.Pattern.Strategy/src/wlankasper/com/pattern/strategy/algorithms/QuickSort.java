package wlankasper.com.pattern.strategy.algorithms;

public class QuickSort extends AlgorithmsPattern {

    /*
    Complessità:
        Caso peggiore - O(n^2)
        Caso medio    - O(n log(n))
        Miglior caso  - O(n)
    Memoria:
        Memoria - O(n)
*/

    public QuickSort(double[] copyArray) {
        super(copyArray, "QuickSort");
    }

    @Override
    public void sortArray() {
        quickSort(0, copyArray.length-1);
    }

    private void quickSort (int start, int end){
        int i = start, j = end;
        double pivot = copyArray[start + (end - start) / 2];

        double exchange;
        while (i <= j) {
            while (copyArray[i] < pivot) {
                i++;
            }
            while (copyArray[j] > pivot) {
                j--;
            }

            if (i <= j) {
                exchange = copyArray[i];
                copyArray[i] = copyArray[j];
                copyArray[j] = exchange;
                i++;
                j--;
            }
        }
        if (start < j)
            quickSort(start, j);
        if (i < end)
            quickSort(i, end);
    }
}
