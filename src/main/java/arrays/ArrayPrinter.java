package arrays;

public class ArrayPrinter {

    public static void printArray(int [] array, int arraySize){
        System.out.println("Array:");
        for (int i =0; i< arraySize; i++){
            System.out.print(" |" + i + "| ");
            System.out.println(array[i]);
        }
    }
}
