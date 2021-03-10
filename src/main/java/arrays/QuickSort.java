package arrays;

public class QuickSort {

    public static void quickSort(int [] array, int arraySize){
        System.out.println("Quick sort");
        quickSortRecursive(array, 0, arraySize-1);
        ArrayPrinter.printArray(array, arraySize);
    }


    private static void quickSortRecursive(int [] array, int low, int high){
        if (low<high){
            int pi = partition(array, low, high);

            quickSortRecursive(array, low, pi -1);
            quickSortRecursive(array, pi + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low-1);

        for(int j = low; j<high;j++){

            if(array[j]<=pivot){
                i++;
                swapValues(array,i, j);
            }
        }
        swapValues(array, i+1, high);
        return (i+1);
    }

    private static void swapValues(int[] array, int indexOne, int indexTwo) {
        int temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }

}
