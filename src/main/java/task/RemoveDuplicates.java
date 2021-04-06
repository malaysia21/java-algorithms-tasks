package task;

import java.util.Arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {

        int[] array1 = new int [] {1,1,2};
        int[] array2 = new int [] {0,0,1,1,1,2,2,3,3,4};
        int[] array3 = new int [] {0,1,1,1,2,2,3,3,4};

        System.out.println("New length: " + removeDuplicatesSolution1(array1));
        System.out.println("New array: " + Arrays.toString(array1));

        System.out.println("New length: " + removeDuplicatesSolution1(array2));
        System.out.println("New array: " + Arrays.toString(array2));

        System.out.println("New length: " + removeDuplicatesSolution2(array3));
        System.out.println("New array: " + Arrays.toString(array3));

    }


    private static int removeDuplicatesSolution1(int[] nums) {
        if(nums.length != 0) {
            int value = nums[0];
            int valueIndex = 0;


            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != value) {
                    value = nums[i];
                    nums[++valueIndex] = value;
                }
            }

            return ++valueIndex;
        } return 0;
    }

    private static int removeDuplicatesSolution2(int[] nums) {
        if(nums.length == 0) return 0;

        int index = 0;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[index]) {
                    nums[++index] = nums[i];
                }
            }
            return ++index;
    }
}
