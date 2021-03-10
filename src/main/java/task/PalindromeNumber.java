package task;

public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println("Is palindrome: " + isPalindromeSolution1(123));
        System.out.println("Is palindrome: " + isPalindromeSolution1(121));
        System.out.println("Is palindrome: " + isPalindromeSolution1(-121));
        System.out.println("Is palindrome: " + isPalindromeSolution1(6));

        System.out.println("Is palindrome: " + isPalindromeSolution2(123));
        System.out.println("Is palindrome: " + isPalindromeSolution2(121));
        System.out.println("Is palindrome: " + isPalindromeSolution2(-121));
        System.out.println("Is palindrome: " + isPalindromeSolution2(6));
    }

    private static boolean isPalindromeSolution1(int x) {
        if(x < 0){
            return false;
        }

        String stringInt = String.valueOf(x);
        int intLength = stringInt.length();
        char[] tempArray = new char [intLength];

        for(int i =0; i< intLength; i++){
            tempArray[i] = stringInt.charAt(i);
        }

        for(int i = 0; i <intLength/2; i++ ){
            if(tempArray[i] != tempArray[intLength-1-i]){
                return false;
            }
        }

        return true;
    }

    private static boolean isPalindromeSolution2(int x) {

      int reversedInteger = 0;
      int remainder;
      int originalInteger = x;

        while( x > 0 )
        {
            remainder = x % 10;
            reversedInteger = reversedInteger * 10 + remainder;
            x  /= 10;
        }

        return  originalInteger == reversedInteger;
    }

}
