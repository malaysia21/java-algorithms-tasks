package heaps;

import lombok.Data;
import java.util.Arrays;

//parents are greater than children
@Data
public class Heap {
    private HeapData[] heap;
    private int itemsInArray = 0;
    private int maxSize;

    Heap(int maxSize) {
        this.maxSize = maxSize;
        this.heap = new HeapData[maxSize];
    }

    private void insert(int index, HeapData newHeapData) {
        heap[index] = newHeapData;
    }

    private void incrementArray() {
        itemsInArray++;
    }

    private void generateFilledArray(int randomNumber) {
        HeapData randomHeapData;
        for (int i = 0; i < maxSize; i++) {
            randomHeapData = new HeapData((int) (Math.random() * randomNumber) + 1);
            insert(i, randomHeapData);
            incrementArray();
        }
    }

    private HeapData pop() {
        int tempItemsInArray = itemsInArray - 1;
        System.out.println("Store " + heap[0] + " in root. Store " + heap[tempItemsInArray] + " in index 0");

        HeapData root = heap[0];
        heap[0] = heap[--itemsInArray];
        heapArray(0);
        return root;

    }

    private void heapArray(int index) {
        int largestChild;
        HeapData root = heap[index];

        while (index < itemsInArray / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;

            if (rightChild < itemsInArray && heap[leftChild].getKey() < heap[rightChild].getKey()) {
                largestChild = rightChild;
            } else {
                largestChild = leftChild;
            }
            if (root.getKey() >= heap[largestChild].getKey()) {
                break;
            }

            heap[index] = heap[largestChild];
            index = largestChild;

        }

        heap[index] = root;
    }

    private void heapSort() {
        for (int k = maxSize - 1; k > 0; k--) {
            HeapData largestNode = pop();
            insert(k, largestNode);
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

            for (int j = 0; j < indent[iteration - 1]; j++) {
                System.out.print(" ");
            }

            for (int l = indexToPrint; l < maxIndexToPrint; l++) {

                if (l < itemsInArray) {

                    System.out.print(String.format("%02d", heap[l].getKey()));

                    for (int k = 0; k < spaces; k++) {
                        System.out.print(" ");
                    }
                }
            }

            spaces = indent[iteration - 1];
            iteration++;
            System.out.println();
        }

    }

    private int[] getIndentArray(int rows) {
        int[] indentArray = new int[rows];
        for (int i = 0; i < rows; i++) {
            int indent = (int) Math.abs((-2 + (Math.pow(2, i + 1))));
            indentArray[i] = indent;
        }
        Arrays.sort(indentArray);
        reverseArray(indentArray);
        return indentArray;
    }

    private void reverseArray(int[] indentArray) {
        int leftIndex = 0;
        int rightIndex = indentArray.length - 1;

        while (leftIndex < rightIndex) {
            int temp = indentArray[leftIndex];
            indentArray[leftIndex] = indentArray[rightIndex];
            indentArray[rightIndex] = temp;
            rightIndex--;
            leftIndex++;
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap(7);
        heap.generateFilledArray(90);

        System.out.println("Original Array");
        System.out.println(Arrays.toString(heap.getHeap()));
        heap.printHeap(5);

        System.out.println();
        for (int j = heap.maxSize / 2 - 1; j >= 0; j--) {
            heap.heapArray(j);
        }

        System.out.println("Heaped Array");
        System.out.println(Arrays.toString(heap.getHeap()));
        heap.printHeap(5);

        System.out.println("Pop");
        heap.pop();
        System.out.println(Arrays.toString(heap.getHeap()));
        heap.printHeap(5);

        System.out.println("Sorted Array");
        heap.heapSort();
        System.out.println(Arrays.toString(heap.getHeap()));
        heap.printHeap(5);
    }
}

@Data
class HeapData {
    private int key;

    HeapData(int key) {
        this.key = key;
    }

    public String toString() {
        return "" + key;
    }
}
