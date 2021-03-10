package arrays;

import lombok.extern.java.Log;

@Log
public class InsertionSort {

    public static void insertionSort(int [] array, int arraySize){
        System.out.println("Insertion Sort");
        for(int i =1; i<arraySize; i++){
            int j = i;
            int toInsert = array[i];

            while(j>0 && array[j-1]>toInsert){
                array[j] = array[j-1];
                j--;
            }
            array[j] = toInsert;
        }
        ArrayPrinter.printArray(array, arraySize);
    }
}
