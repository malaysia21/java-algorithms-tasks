package task.bitmanipulation;

public class SumBitDifferences {

    public static void main(String[] args) {
        int[] arr = {1, 2};
        int[] arr2 = {1, 3, 5};

        System.out.println(sumBitDifferences(arr)); //4
        System.out.println(sumBitDifferences(arr2)); //8
    }

    private static int sumBitDifferences(int[] arr) {
        int result = 0;
        int travers = 32;
        int length = arr.length;

        for (int i = 0; i < travers; i++) {

            int oneZero = 0;

            for (int j = 0; j < length; j++) {

                if ((arr[j] & (1 << i)) == 0) {
                    oneZero++;
                }
                System.out.println(" BIT: " + i + " INDEX: " + j + " BINARY: " + String.format("%32s", Integer.toBinaryString(arr[j])).replaceAll(" ", "0"));
            }

            result += (oneZero * (length - oneZero));
        }

        return result * 2;
    }

}
