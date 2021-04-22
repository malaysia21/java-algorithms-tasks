package task.bitmanipulation;

public class SumBitDifferences {

    public static void main(String[] args) {
        int [] arr = {1, 2};
        int [] arr2 = {1, 3, 5};

        System.out.println(sumBitDifferences(arr));
        System.out.println(sumBitDifferences(arr2));
    }

    private static  int sumBitDifferences(int [] arr) {
        int result = 0;
        int travers = 32;
        int length = arr.length;

        for (int i = 1; i<= travers; i++){

            int oneCount = 0;

            for(int j = 0; j<length;j++){

                if ((arr[j] & 1) == 1){
                    oneCount++;
                }

                System.out.println(" BIT: " + i + " INDEX: " + j + " BINARY: " + String.format("%32s",Integer.toBinaryString(arr[j])).replaceAll(" ", "0"));
                arr[j] >>= 1;

            }

            result += (oneCount*(length - oneCount));
        }

        return result*2;
    }

}
