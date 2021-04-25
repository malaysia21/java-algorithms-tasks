package task.array;

import java.util.Arrays;

public class ConvertToZigZag {

    public static void main(String[] args) {
        int [] arr1 =  {4, 3, 7, 8, 6, 2, 1};
        int [] arr2 = {1, 4, 3, 2};

        System.out.println(Arrays.toString(convertToZigZagSolution1(arr1)));
        System.out.println(Arrays.toString(convertToZigZagSolution1(arr2)));


        System.out.println(Arrays.toString(convertToZigZagSolution2(arr1)));
        System.out.println(Arrays.toString(convertToZigZagSolution2(arr2)));

        System.out.println(Arrays.toString(convertToZigZagSolution3(arr1)));
        System.out.println(Arrays.toString(convertToZigZagSolution3(arr2)));

    }

    private static int[] convertToZigZagSolution1(int [] array){
        Arrays.sort(array);

        for(int i =1; i <array.length-1; i=i+2){
            int temp = array[i];
            array[i] = array[i+1];
            array[i+1] = temp;
        }

        return array;
    }

    private static int[] convertToZigZagSolution2(int [] array) {
        boolean smallerThanNext = true;
        int index = 0;

        while(index < array.length -1) {

            if ((array[index] > array[index + 1] && smallerThanNext) ||(array[index] < array[index + 1] && !smallerThanNext )) {
                int temp = array[index];
                array[index] = array[index + 1];
                array[index + 1] = temp;
            }

            index++;
            smallerThanNext = !smallerThanNext;
        }

        return array;
    }

    private static int[] convertToZigZagSolution3(int [] array){
        boolean smallerThanNext = true;

        int temp;

        for (int i=0; i<=array.length-2; i++)
        {
            if (smallerThanNext)
            {
                if (array[i] > array[i+1])
                {
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }

            }
            else
            {

                if (array[i] < array[i+1])
                {
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
            smallerThanNext = !smallerThanNext;
        }

        return array;
    }
}
