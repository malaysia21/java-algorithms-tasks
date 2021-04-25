package task.array;

import java.util.Arrays;

public class CountTripletsSum {

    public static void main(String[] args) {

        int [] array1 = {5, 1, 3, 4, 7};
        int [] array2 = {-2, 0, 1, 3};

        System.out.println(countTripletsWithSumLowerThenGiven(array1, 12));
        System.out.println(countTripletsWithSumLowerThenGiven(array2, 2));

    }

    private static int countTripletsWithSumLowerThenGiven(int [] array, int sum){
        Arrays.sort(array);

        int result = 0;
        int n = array.length;

        for (int i = 0; i < n - 2; i++)
        {
            int j = i + 1, k = n - 1;

            while (j < k)
            {
                if (array[i] + array[j] + array[k] >= sum)
                    k--;

                else
                {
                    result += (k - j);
                    j++;
                }
            }
        }
        return result;



    }
}
