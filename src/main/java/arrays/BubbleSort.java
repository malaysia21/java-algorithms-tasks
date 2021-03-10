package arrays;

import lombok.extern.java.Log;

public class BubbleSort {

    public static void bubbleSort(int[] array, int arraySize) {
        System.out.println("Bubble sort");
        for (int i = arraySize - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    swapValues(array, j, j + 1);
                }
            }
        }
        ArrayPrinter.printArray(array, arraySize);
    }

    public static void bubbleSortDescendingOrder(int[] array, int arraySize){
        System.out.println("Bubble Sort - descending order");
        for(int i = arraySize-1; i>0; i-- ){

            for(int j = 0; j<i; j++){
                if(array[j]<array[j+1]){
                    swapValues(array, j, j+1);
                }
            }
        }
        ArrayPrinter.printArray(array, arraySize);
    }

    private static void swapValues(int[] array, int indexOne, int indexTwo) {
        int temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }


}
