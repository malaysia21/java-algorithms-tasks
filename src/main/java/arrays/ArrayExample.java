package arrays;

public class ArrayExample {

    public static void main(String[] args) {
        ArrayClass arrayExample = new ArrayClass();
        arrayExample.generateArray();

        int indexSearched = 3;
        System.out.println("Value at index: " + indexSearched + " - " + arrayExample.getValueAtIndex(indexSearched));

        int valueSearched = 18;
        System.out.println("Does array contain value: " +  valueSearched + " - " + arrayExample.doesArrayContainValue(valueSearched));

        int deleteIndex = 4;
        arrayExample.deleteIndex(deleteIndex);

        int insertValue = 55;
        arrayExample.insertValue(insertValue);

        arrayExample.linearSearchOfValue(17);

        arrayExample.binarySearchOfValue(17);

        ArrayClass arraySelectionSort = new ArrayClass();
        arraySelectionSort.generateArray();
        SelectionSort.selectionSort(arraySelectionSort.getArray(), arraySelectionSort.getArraySize());

        ArrayClass arrayBubbleSort = new ArrayClass();
        arrayBubbleSort.generateArray();
        BubbleSort.bubbleSort(arrayBubbleSort.getArray(), arrayBubbleSort.getArraySize());

        ArrayClass arrayInsertionSort = new ArrayClass();
        arrayInsertionSort.generateArray();
        InsertionSort.insertionSort(arrayInsertionSort.getArray(), arrayInsertionSort.getArraySize());

        ArrayClass arrayQuickSort = new ArrayClass();
        arrayQuickSort.generateArray();
        QuickSort.quickSort(arrayQuickSort.getArray(), arrayQuickSort.getArraySize());

        ArrayClass arrayMergeSort = new ArrayClass();
        arrayMergeSort.generateArray();
        MergeSort.mergeSort(arrayMergeSort.getArray(), arrayMergeSort.getArraySize());

        ArrayClass arrayShellSort = new ArrayClass();
        arrayShellSort.generateArray();
        ShellSort.shellSort(arrayShellSort.getArray(), arrayShellSort.getArraySize());
    }
}
