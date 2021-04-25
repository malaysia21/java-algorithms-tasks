package task.array;

import java.util.Arrays;
import java.util.HashSet;

public class CountTwoSum {

    public static void main(String[] args) {
        int [] array1 = {0, -1, 2, -3, 1};
        int [] array2 = {1, -2, 1, 0, 5};

        System.out.println(hasTwoElementSumEqualsGivenPointers(array1, -2));
        System.out.println(hasTwoElementSumEqualsGivenPointers(array2, 0));

        System.out.println(hasTwoElementSumEqualsGivenHashSet(array1, -2));
        System.out.println(hasTwoElementSumEqualsGivenHashSet(array2, 0));
    }

    private static String hasTwoElementSumEqualsGivenPointers(int [] array, int sum) {
        StringBuilder result = new StringBuilder();
        Arrays.sort(array);

        int k = 0 ;
        int j = array.length-1;

        while(k<j){
            if(array[k] + array[j]> sum){
                j--;
            } else if (array[k] + array[j]< sum){
                k++;
            } else {
                result.append("Result: ").append(array[k]).append(" i ").append(array[j]).append(" ");
                k++;
                j++;
            }

        }

       return result.length() == 0 ? "No result" : result.toString();

    }

    private static String hasTwoElementSumEqualsGivenHashSet(int [] array, int sum) {
        StringBuilder result = new StringBuilder();
        Arrays.sort(array);
        HashSet<Integer> set = new HashSet<>();

        for (int value : array) {
            int temp = sum - value;

            if (set.contains(temp)) {
                result.append("Result: ").append(value).append(" i ").append(temp).append(" ");
            } else {
                set.add(value);
            }
        }


        return result.length() == 0 ? "No result" : result.toString();

    }

    //TODO lower/greater then sum
}
