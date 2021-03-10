package task;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int [] array1 =  {2,7,11,15};
        int [] array2 =  {3,2,4};

        System.out.println(Arrays.toString(twoSumSolution1(array1, 9)));
        System.out.println(Arrays.toString(twoSumSolution1(array2, 6)));

        System.out.println(Arrays.toString(twoSumSolution2(array1, 9)));
        System.out.println(Arrays.toString(twoSumSolution2(array2, 6)));

        System.out.println(Arrays.toString(twoSumSolution3(array1, 9)));
        System.out.println(Arrays.toString(twoSumSolution3(array2, 6)));
    }

    private static int[] twoSumSolution1(int[] array, int target){
        int[] result = new int[2];
        boolean findResult = false;

        for (int i=0; i< array.length; i++){
                int x = target - array[i];

                for(int j=i+1; j<array.length; j++){
                    if(array[j]==x){
                        result[0] = i;
                        result[1] = j;
                        findResult=true;
                        break;
                    }
                }
            if(findResult) break;
        }
        return result;
    }

    private static int[] twoSumSolution2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i <nums.length; i++){

            int value = target - nums[i];

            if(map.containsKey(value)){

                return new int[] {i, map.get(value)};
            }
            map.put(nums[i], i);
        }
        throw new RuntimeException();
    }

    private static int[] twoSumSolution3(int [] array, int target){
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] == target - array[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
