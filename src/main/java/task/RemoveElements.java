package task;

import java.util.Arrays;

public class RemoveElements {

    public static void main(String[] args) {
        int[] array1 = new int[] {3,2,2,3};
        int[] array2 = new int[] {0,1,2,2,3,0,4,2};
        int[] array3 = new int[] {0,2,2,2,3,0,2,2};

        System.out.println("Result:" + removeElement(array1, 3) );
        System.out.println(Arrays.toString(array1));

        System.out.println("Result:" + removeElement(array2, 2) );
        System.out.println(Arrays.toString(array2));

        System.out.println("Result:" + removeElementSolution2(array3, 2) );
        System.out.println(Arrays.toString(array3));
    }

    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i< nums.length; i++){
            if(nums[i] !=val){
               nums[index] = nums[i];
               index++;
            }
        }


        return index;
    }

    public static int removeElementSolution2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}
