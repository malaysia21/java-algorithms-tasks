package notation;


public class BigONotation {

    private int[] array;
    private int arraySize;
    private int itemInArrays = 0;

    public static void main(String[] args) {

        BigONotation test1 = new BigONotation(10000);
        test1.generateArray();
        BigONotation test2 = new BigONotation(30000);
        test2.generateArray();

        System.out.println("\nO(N) - linear search (with String Builder)");
        test1.linearSearchForValue(11);
        test2.linearSearchForValue(11);

        System.out.println("\nO(N) - linear search (with String concatenation");
        test1.linearSearchForValueWithStringConcat(11);
        test2.linearSearchForValueWithStringConcat(11);


        System.out.println("\nO(N^2) - bubble sort");
        test1.bubbleSort();
        test2.bubbleSort();

        System.out.println("\nO(log N) - binary sort");
        test1.binarySearch(11);
        test2.binarySearch(11);

        System.out.println("\nO(N log N) - quick sort");
        test1.quickSortMethod();
        test2.quickSortMethod();
    }

    private BigONotation(int arraySize) {
        this.arraySize = arraySize;
        array = new int[arraySize];
    }

    private void generateArray() {
        for(int i = 0; i<arraySize; i++){
            array[i] = (int) ((Math.random()*10) + 10);
        }
        itemInArrays = arraySize - 1;
    }

    //O(1) - algorithm behaves regardless of amount of data
    private  void addItemToArray(int newItem){
        array[itemInArrays++] = newItem;
    }

    //O(N) - grow linear with amount of data
    private void linearSearchForValue(int value) {
        boolean valueInArray =  false;
        long startTime = System.currentTimeMillis();
        StringBuilder indexesWithValue = new StringBuilder();

        for (int i = 0; i < arraySize; i++) {
            if (array[i] == value) {
                valueInArray = true;
                indexesWithValue.append(i).append(" ");
            }
        }
        long endTime = System.currentTimeMillis();

        System.out.println("Value Found: " + valueInArray);
        System.out.println("Linear Search took " + (endTime - startTime));
        System.out.println("Indexes with value: " + indexesWithValue);
    }

    //O(N) - grow linear with amount of data
    private void linearSearchForValueWithStringConcat(int value) {
        boolean valueInArray = false;
        long startTime = System.currentTimeMillis();
        String indexesWithValue = "";

        for (int i = 0; i < arraySize; i++) {

                if (array[i] == value) {
                    valueInArray = true;
                    indexesWithValue += i + " ";
                }
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Value Found: " + valueInArray);
        System.out.println("Linear Search Took " + (endTime - startTime));
        System.out.println("Indexes with value: " + indexesWithValue);
    }

    //O(N^2) - time proportional to square of data
    private void bubbleSort() {
        long startTime = System.currentTimeMillis();

        for(int i = arraySize -1; i > 1; i--){

            for(int j=0; j <i; j++){
                if(array[j]> array[j+1]) {
                    swapValues(j, j+1);
                }
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Bubble sort took " + (endTime - startTime));

    }

    //O(lon N)
    private void binarySearch(int value) {
        long startTime = System.currentTimeMillis();

        int lowIndex = 0;
        int highIndex = arraySize -1;

        while(lowIndex <= highIndex) {

            int middleIndex =  (highIndex - lowIndex)/2;

            if(array[middleIndex]< value){
                lowIndex = middleIndex + 1;
            } else if (array[middleIndex] > value) {
                highIndex = middleIndex -1;
            } else {
                System.out.println("Found match in index: " + middleIndex);
                lowIndex = highIndex +1;
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Binary search took " + (endTime - startTime));
    }

    //O(N lon N)
    private void quickSortMethod(){
        long startTime = System.currentTimeMillis();
        quickSort(0, arraySize-1);
        long endTime = System.currentTimeMillis();
        System.out.println("Quick sort took " + (endTime - startTime));
    }

    private void quickSort(int left, int right){
        if(right - left <= 0){
            return;
        }
        else {
            int pivot = array[right];
            int pivotLocation =  partitionArray(left, right, pivot);
            quickSort(left, pivotLocation -1);
            quickSort(pivotLocation +1, right);
        }

    }

    private int partitionArray(int left, int right, int pivot) {
        int leftPointer = left -1;
        int rightPointer =  right;

        while(true){

            while (array[++leftPointer] < pivot);

            while (rightPointer > 0 && array[--rightPointer] > pivot);

            if(leftPointer>= rightPointer){
                break;
            } else {
                swapValues(leftPointer, rightPointer);
            }
        }
        return leftPointer;
    }


    private void swapValues(int oneIndex, int twoIndex){
        int temp = array[oneIndex];
        array[oneIndex] = array[twoIndex];
        array[twoIndex] = temp;
    }

}
