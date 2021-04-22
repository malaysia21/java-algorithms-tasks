package task.bitmanipulation;

public class MagicNumber {

    public static void main(String[] args) {
        System.out.println("Magic number: " + magicNumberSolution1(5));
        System.out.println("Magic number: " + magicNumberSolution1(13));

    }

    private static int magicNumberSolution1(int n) {
        int pow = 1;
        int result = 0;

        while (n != 0) {
            pow = pow * 5;

            if ((n & 1) == 1)
                result += pow;

            n >>= 1;
        }
        return result;
    }
}
























