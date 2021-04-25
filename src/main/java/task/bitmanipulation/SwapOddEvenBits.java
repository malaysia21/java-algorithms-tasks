package task.bitmanipulation;

public class SwapOddEvenBits {

    public static void main(String[] args) {
        int x = 23; // 00010111
        int x2 = 5; // 00000101

        // Output is 43 (00101011)
        System.out.println(swapBits(x));
        // Output is 10 (00001010)
        System.out.println(swapBits(x2));
    }

    private static int swapBits(int x)
    {
        // Get all even bits of x
        int even_bits = x & 0xAAAAAAAA;

        // Get all odd bits of x
        int odd_bits = x & 0x55555555;

        // Right shift even bits
        even_bits >>= 1;

        // Left shift even bits
        odd_bits <<= 1;

        return (even_bits | odd_bits);
    }
}
