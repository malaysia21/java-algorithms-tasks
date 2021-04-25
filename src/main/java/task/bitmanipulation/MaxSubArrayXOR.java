package task.bitmanipulation;

public class MaxSubArrayXOR {

    public static void main(String[] args) {
        int[] arr = {8, 1, 2, 12, 7, 6};
        int[] arr2 = {4, 6};
        System.out.println("Max subArray XOR: " + findMaxSubArrayXORSolution1(arr));
        System.out.println("Max subArray XOR: " + findMaxSubArrayXORSolution1(arr2));
        System.out.println("Max subArray XOR: " + maxSubArrayXORSolution2(arr2));
    }

    private static int findMaxSubArrayXORSolution1(int[] arr)
    {
        int result = Integer.MIN_VALUE;
        int n = arr.length;

        for (int i=0; i<n; i++)
        {
            int currentXORValue = 0;

            for (int j=i; j<n; j++)
            {
                currentXORValue = currentXORValue ^ arr[j];
                result = Math.max(result, currentXORValue);
            }
        }
        return result;
    }

    static TrieNode root;
    static final int INT_SIZE = 32;

    static int maxSubArrayXORSolution2(int[] arr)
    {
        root = new TrieNode();
        insert(0);

        int result = Integer.MIN_VALUE;
        int pre_xor =0;

        for (int j : arr) {
            pre_xor = pre_xor ^ j;
            insert(pre_xor);
            result = Math.max(result, query(pre_xor));

        }
        return result;
    }



    private static class TrieNode
    {
        int value;
        TrieNode[] arr =  new TrieNode[2];
        public TrieNode() {
            value = 0;
            arr[0] = null;
            arr[1] = null;
        }
    }

    private static void insert(int pre_xor)
    {
        TrieNode temp = root;

        for (int i=INT_SIZE-1; i>=0; i--)
        {
            int val = (pre_xor & (1<<i)) >=1 ? 1 : 0;

            if (temp.arr[val] == null)
                temp.arr[val] = new TrieNode();

            temp = temp.arr[val];
        }

        temp.value = pre_xor;
    }

    private static int query(int pre_xor)
    {
        TrieNode temp = root;
        for (int i=INT_SIZE-1; i>=0; i--)
        {
            // Find current bit in given prefix
            int val = (pre_xor & (1<<i)) >= 1 ? 1 : 0;

            // Traverse Trie, first look for a
            // prefix that has opposite bit
            if (temp.arr[1-val] != null)
                temp = temp.arr[1-val];

                // If there is no prefix with opposite
                // bit, then look for same bit.
            else if (temp.arr[val] != null)
                temp = temp.arr[val];
        }
        return pre_xor^(temp.value);
    }


}


