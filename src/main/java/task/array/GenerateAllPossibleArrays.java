package task.array;

public class GenerateAllPossibleArrays {

    public static void main(String[] args) {
        int [] arrayA = {10, 15, 25};
        int [] arrayB = {1, 5, 20, 30};
        generateAllPossibleArray(arrayA, arrayB);
    }

    private static void generateAllPossibleArray(int [] arrayA, int [] arrayB){
        int lengthArrayA = arrayA.length;
        int lengthArrayB = arrayB.length;
        int [] arrayC = new int[lengthArrayA + lengthArrayB];

        /* output array */
        generateAllPossibleArrayRecursion(arrayA, arrayB, arrayC, 0, 0, lengthArrayA, lengthArrayB, 0, true);


    }
    private static void generateAllPossibleArrayRecursion(int [] arrayA, int [] arrayB, int [] arrayC, int i, int j, int lengthArrayA, int lengthArrayB,
                                                          int lengthArrayC, boolean flag){
        if (flag) // Include valid element from A
        {
            // Print output if there is at least one 'B' in output array 'C'
            if (lengthArrayC != 0) {
                printArr(arrayC, lengthArrayC +1);
            }

            // Recur for all elements of A after current index
            for (int k = i; k < lengthArrayA; k++)
            {
                if (lengthArrayC == 0)
                {
                    /* this block works for the very first call to include
                    the first element in the output array */
                    arrayC[lengthArrayC] = arrayA[k];

                    // don't increment lem as B is included yet
                    generateAllPossibleArrayRecursion(arrayA, arrayB, arrayC, k + 1, j, lengthArrayA, lengthArrayB, lengthArrayC, !flag);
                }

                /* include valid element from A and recur */
                else if (arrayA[k] > arrayC[lengthArrayC])
                {
                    arrayC[lengthArrayC + 1] = arrayA[k];
                    generateAllPossibleArrayRecursion(arrayA, arrayB, arrayC, k + 1, j, lengthArrayA, lengthArrayB, lengthArrayC + 1, !flag);
                }
            }
        }

        /* Include valid element from B and recur */
        else
        {
            for (int l = j; l < lengthArrayB; l++)
            {
                if (arrayB[l] > arrayC[lengthArrayC])
                {
                    arrayC[lengthArrayC + 1] = arrayB[l];
                    generateAllPossibleArrayRecursion(arrayA, arrayB, arrayC, i, l + 1, lengthArrayA, lengthArrayB, lengthArrayC + 1, !flag);
                }
            }
        }

    }

    private static void printArr(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }
}
