package arrays;

import lombok.Data;

@Data
public class ArrayClass {

    private int [] array = new int [50];
    private int arraySize = 10;
    private int arrayLength = array.length;

    public void generateArray() {
        System.out.println("Generated array:");
        for(int i =0; i<arraySize; i++){
            array[i] = (int) ((Math.random()*10) + 10);
        }
        ArrayPrinter.printArray(array, arraySize);
    }

    public int getValueAtIndex(int index){
      return array[index];
    }

    public boolean doesArrayContainValue(int value){
        boolean valueInArray = false;

        for(int i =0; i <arraySize; i++){
            if(array[i] == value){
                valueInArray = true;
                break;
            }
        }
        return valueInArray;
    }

    public void deleteIndex(int indexToDelete){
        if(indexToDelete<arraySize) {
            System.out.println("Deleted index: " + indexToDelete);
            for (int i = indexToDelete; i < arraySize - 1; i++) {
                array[i] = array[i + 1];
            }
            arraySize--;
            ArrayPrinter.printArray(array, arraySize);
        } else {
            System.out.println("Value not deleted");
        }

    }

    public void insertValue(int value) {
        if(arraySize<arrayLength) {
            System.out.println("Insert value: " + value);
            array[arraySize] = value;
            arraySize++;
            ArrayPrinter.printArray(array, arraySize);
        } else {
            System.out.println("Value not inserted");
        }
    }

    public void linearSearchOfValue(int value){
        boolean valueInArray = false;
        String indexWithValue = "";

        for(int i =0; i < arraySize; i++){
            if(array[i] == value){
                valueInArray = true;
                indexWithValue = indexWithValue.concat(i +" ");
            }
        }

        if(!valueInArray){
            indexWithValue = "None";
        }

        System.out.println("The value " + value + " was found in index: " +  indexWithValue);
    }

    public void binarySearchOfValue(int value){
        QuickSort.quickSort(array, arraySize);

        int lowIndex = 0;
        int highIndex = arraySize -1;

        while(lowIndex <= highIndex){
            int middleIndex = (highIndex +  lowIndex)/2;

            if(array[middleIndex] < value){
                lowIndex = middleIndex +1;
            } else if (array[middleIndex] > value){
                highIndex = middleIndex -1;
            } else  {
                System.out.println("Found a value " + value + " at index " + middleIndex);
                lowIndex = highIndex +1;
            }
        }
    }

}
