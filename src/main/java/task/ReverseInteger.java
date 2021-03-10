package task;

public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(157));
        System.out.println(reverse(-100));

        System.out.println(reverse2(15766));
        System.out.println(reverse2(-100));
    }

    private static int reverse(int x) {
        String intString = String.valueOf(x);
        StringBuilder result = new StringBuilder();
        int firstNumberIndex = 0;

        if (intString.charAt(0) == '-') {
            firstNumberIndex = 1;
            result = new StringBuilder("" + intString.charAt(0));
        }

        for (int i = intString.length() - 1; i >= firstNumberIndex; i--) {
            result.append(intString.charAt(i));
        }

        try {
            return Integer.parseInt(result.toString());
        } catch (Exception ex) {
            return 0;
        }
    }

    private static int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
