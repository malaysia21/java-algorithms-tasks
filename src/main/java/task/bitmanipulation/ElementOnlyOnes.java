package task.bitmanipulation;

import java.util.HashSet;
import java.util.Set;

public class ElementOnlyOnes {

    public static void main(String[] args) {
        int [] array = { 3,3,3,7 };
        System.out.println("Single element: " + singleElementSolution1(array));
        System.out.println("Single element: " + singleElementSolution2(array));

        int [] array2 = { 3, 3, 2, 3 };
        System.out.println("Single element: " + singleElementSolution1(array2));
        System.out.println("Single element: " + singleElementSolution2(array2));

        int [] array3={12, 1, 12, 3, 12, 1, 1, 2, 3, 2, 2, 3, 7};
        System.out.println("Single element: " + singleElementSolution1(array3));
        System.out.println("Single element: " + singleElementSolution2(array3));
    }

    private static int singleElementSolution1(int [] arr){
        Set<Integer> setOfInteger = new HashSet<>();


        for (int item : arr) {
            setOfInteger.add(item);
        }

        int arraySum = 0;
        int setSum = 0;

        for (Integer element : setOfInteger) {
            setSum+=element;
        }
        for (int item : arr) {
            arraySum+=item;
        }

        return ((3*setSum) -arraySum)/2;

    }

    private static int singleElementSolution2(int [] arr){
       int result = 0;
       final int MAX_BIT =32;

       for(int i =0; i< MAX_BIT; i++){

           int bitSum = 0;

           for (int j=0; j<arr.length; j++) {
               if ((arr[j] & (1 << i)) != 0) {
                   bitSum++;
               }
           }
           if(bitSum % 3 == 1){
              result=  (result | (1 <<i));
           }

       }
        return result;
    }

}
