package arrays;

import lombok.extern.java.Log;

@Log
public class SelectionSort {

    public static void selectionSort(int[] array, int arraySize) {
        System.out.println("Selection sort");
        for (int i = 0; i <arraySize - 1; i++) {
            int minimum = i;
            for (int y = i +1 ; y < arraySize; y++) {
                if (array[minimum] > array[y]) {
                    minimum = y;
                }
            }
            swapValues(array, i, minimum);
        }
        ArrayPrinter.printArray(array, arraySize);
    }

    private static void swapValues(int[] array, int indexOne, int indexTwo) {
        int temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }

}
