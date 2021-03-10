package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HashFunction {

    public static void main(String[] args) {
        HashFunction hashExample = new HashFunction(31);
        String[] elementsToAdd = {"100", "510", "170", "214", "268", "398",
                "235", "802", "900", "723", "699", "1", "16", "999", "890",
                "725", "998", "978", "988", "990", "989", "984", "320", "321",
                "400", "415", "450", "50", "660", "624"};

        //simple hash function ver.2
        hashExample.hashFunction(elementsToAdd, hashExample.array);
        hashExample.displayHashTable();

        //find key in hash table
        hashExample.findKey("660");

        //increase table size
        hashExample.increaseArraySize(60);
        hashExample.displayHashTable();

        //doubleHashFunction (avoid clustering)
        hashExample.fillArrayWithNeg();
        hashExample.doubleHashFunction(elementsToAdd, hashExample.array);
        hashExample.displayHashTable();

        //find key in double hash table
        hashExample.findKeyDoubleHash("989");
    }

    private String[] array;
    private int arraySize;
    private int itemsInArray = 0;

    HashFunction(int arraySize) {
        this.arraySize = arraySize;
        array = new String[arraySize];
        Arrays.fill(array, "-1");
    }

    private void hashFunction(String[] stringsForArray, String[] array) {
        for (int n = 0; n < stringsForArray.length; n++) {
            String newElement = stringsForArray[n];
            int hashIndex = Integer.parseInt(newElement) % arraySize;

            System.out.println("Modules Index= " + hashIndex + " for value " + newElement);

            while (!array[hashIndex].equals("-1")) {
                ++hashIndex;
                System.out.println("Collision " + hashIndex + " instead");

                //back to the index 0
                hashIndex %= arraySize;
            }

            array[hashIndex] = newElement;
        }
    }


    private String findKey(String key) {
        int hashIndex = Integer.parseInt(key) % arraySize;

        while (!array[hashIndex].equals("-1")) {
            if (array[hashIndex].equals(key)) {
                System.out.println(key + " was found in index " + hashIndex);

                return array[hashIndex];
            }
            ++hashIndex;
            hashIndex %= arraySize;
        }
        return null;
    }

    private String findKeyDoubleHash(String key) {
        int hashIndex = Integer.parseInt(key) % arraySize;
        int stepDistance = 7 - Integer.parseInt(key) % 7;

        while (!array[hashIndex].equals("-1")) {
            if (array[hashIndex].equals(key)) {
                System.out.println(key + " was found in index " + hashIndex);

                return array[hashIndex];
            }
            hashIndex += stepDistance;
            hashIndex %= arraySize;
        }
        return null;
    }

    private boolean isPrime(int number) {
        if (number % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int getNextPrime(int minNumberToCheck) {
        for (int i = minNumberToCheck; true; i++) {
            if (isPrime(i)) {
                return i;
            }
        }
    }

    private void increaseArraySize(int minArraySize) {
        int newArraySize = getNextPrime(minArraySize);
        moveOldArray(newArraySize);
    }

    private void moveOldArray(int newArraySize) {
        String[] cleanArray = removeEmptySpacesInArray(array);

        array = new String[newArraySize];
        arraySize = newArraySize;
        fillArrayWithNeg();
        hashFunction(cleanArray, array);
    }

    private void fillArrayWithNeg() {
        Arrays.fill(array, "-1");
    }

    private String[] removeEmptySpacesInArray(String[] array) {
        List<String> stringList = new ArrayList<>();
        for (String s : array) {
            if (!s.equals("-1") && !s.isEmpty()) {
                stringList.add(s);
            }
        }
        return stringList.toArray(new String[stringList.size()]);
    }

    private void doubleHashFunction(String[] stringsForArray, String[] array) {
        for (int n = 0; n < stringsForArray.length; n++) {
            String newElement = stringsForArray[n];
            int hashIndex = Integer.parseInt(newElement) % arraySize;
            int stepDistance = 7 - Integer.parseInt(newElement) % 7;

            System.out.println("Modules Index= " + hashIndex + " for value " + newElement);

            while (!array[hashIndex].equals("-1")) {
                hashIndex += stepDistance;
                System.out.println("Collision " + hashIndex + " instead");

                //back to the index 0
                hashIndex %= arraySize;
            }

            array[hashIndex] = newElement;
        }
    }

    private void displayHashTable() {

        int increment = 0;
        int numberOfRows = (arraySize / 10) + 1;

        for (int m = 0; m < numberOfRows; m++) {
            increment += 10;

            for (int n = 0; n < 71; n++)
                System.out.print("-");

            System.out.println();

            for (int n = increment - 10; n < increment; n++) {
                System.out.format("| %3s " + " ", n);
            }

            System.out.println("|");

            for (int n = 0; n < 71; n++)
                System.out.print("-");

            System.out.println();

            for (int n = increment - 10; n < increment; n++) {

                if (n >= arraySize)
                    System.out.print("|      ");
                else if (array[n].equals("-1"))
                    System.out.print("|      ");
                else
                    System.out.print(String.format("| %3s " + " ", array[n]));
            }

            System.out.println("|");

            for (int n = 0; n < 71; n++)
                System.out.print("-");

            System.out.println();
        }

    }
}
