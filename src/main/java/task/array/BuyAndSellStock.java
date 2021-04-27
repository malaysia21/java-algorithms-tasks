package task.array;

/**
 * We have to determine the maximum profit that can be obtained by making the transactions (no limit on the number of transactions done).
 * For this we need to find out those sets of buying and selling prices which together lead to the maximization of profit.
 */
public class BuyAndSellStock {
    public static void main(String[] args) {
        int [] array1 = {7, 1, 5, 3, 6, 4};

        System.out.println(buyAndSellStock(array1));
    }

    private static int buyAndSellStock(int [] array){
        int maxProfit = 0;
        int index = 0;
        int maxValue;
        int minValue ;

        while(index <array.length-1){

            while(index <array.length-1 && array[index] >= array[index+1]){
                index++;
            }
            minValue = array[index];

            while(index <array.length-1 && array[index] <= array[index+1]){
                 index++;
             }
            maxValue = array[index];

            maxProfit += maxValue-minValue;

        }

    return maxProfit;
    }


}
