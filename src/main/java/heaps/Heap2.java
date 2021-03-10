package heaps;

import java.util.Arrays;

//parents are greater than children
public class Heap2 {
    private Data2[] heap;
    private int itemsInArray = 0;
    private int maxSize;

    public Heap2(int maxSize) {
        this.maxSize = maxSize;
        this.heap = new Data2[maxSize];
    }

    private void insert(int index, Data2 newData) {
        heap[index] = newData;
        itemsInArray++;
    }

    

    private void generateFilledArray(int randomNumber) {
        Data2 randomData;
        for (int i = 0; i < maxSize; i++) {
            randomData = new Data2((int) (Math.random() * randomNumber) + 1);
            insert(i, randomData);
        }
    }

    private void printHeap(int rows) {
        int spaces = 0;
        int iteration = 1;

        int[] indent = getIndentArray(rows);

        while (iteration <= rows) {
            int indexToPrint = (int) (.5 * (-2 + (Math.pow(2, iteration))));
            int itemsPerRow = (int) (Math.pow(2, iteration - 1));
            int maxIndexToPrint = indexToPrint + itemsPerRow;

            for (int j = 0; j < indent[iteration-1]; j++) {
                System.out.print(" ");
            }

            for (int l = indexToPrint; l < maxIndexToPrint; l++) {

                if(l < itemsInArray) {

                    System.out.print(String.format("%02d", heap[l].getKey()));

                    for (int k = 0; k < spaces; k++) {
                        System.out.print(" ");
                    }
                }
            }

            spaces = indent[iteration-1];
            iteration++;
            System.out.println();
        }

    }

    private int[] getIndentArray(int rows) {
        int [] indentArray = new int[rows];
        for(int i=0; i< rows; i++){
            int indent =  (int) Math.abs((-2 + (Math.pow(2, i + 1))));
            indentArray[i] = indent;
        }
        Arrays.sort(indentArray);
        indentArray = reverseArray(indentArray);
        return indentArray;
    }

    private int[] reverseArray(int[] indentArray) {
        int leftIndex = 0;
        int rightIndex = indentArray.length -1;

        while(leftIndex < rightIndex){
            int temp = indentArray[leftIndex];
            indentArray[leftIndex] = indentArray[rightIndex];
            indentArray[rightIndex] = temp;
            rightIndex--;
            leftIndex++;
        }
        return indentArray;
    }

    public static void main(String[] args) {
        Heap2 heap = new Heap2(70);
        heap.generateFilledArray(90);

        heap.printHeap(5);
    }
}

@lombok.Data
class Data2 {
    private int key;

    public Data2(int key) {
        this.key = key;
    }

    public String toString(){
        return "" + key;
    }
}
