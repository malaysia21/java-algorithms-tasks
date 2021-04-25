package task.array;

public class ReverseStringWithoutSpecialChar {

    public static void main(String[] args) {
        String example1 = "a,b$c";
        String example2 = "Ab,c,de!$";

        System.out.println(reverseStringSolution1(example1));
        System.out.println(reverseStringSolution1(example2));

        System.out.println(reverseStringSolution2(example1));
        System.out.println(reverseStringSolution2(example2));

    }

    private static String reverseStringSolution1(String s) {
        char[] resultArray = new char[s.length()];
        int pointer = s.length() - 1;

        for (int index = 0; index < s.length(); index++) {

            if (Character.isLetter(s.charAt(index))) {
                while(!Character.isLetter(s.charAt(pointer))){
                    pointer--;
                }
                resultArray[pointer] = s.charAt(index);
                pointer--;
            } else {
                resultArray[index] = s.charAt(index);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i : resultArray) {
            result.append((char)i);
        }

        return result.toString();
    }

    private static String reverseStringSolution2(String s){
        int leftIndex = 0;
        int rightIndex = s.length() -1;
        StringBuilder result = new StringBuilder(s);

       while(leftIndex< rightIndex){

            if(!(Character.isLetter(result.charAt(leftIndex)))){
                leftIndex++;
            } else if(!(Character.isLetter(result.charAt(rightIndex)))){
                rightIndex--;
            } else {
                char tempChar = result.charAt(leftIndex);
                result.setCharAt(leftIndex, result.charAt(rightIndex));
                result.setCharAt(rightIndex, tempChar);
                leftIndex++;
                rightIndex--;
            }
        }

        return result.toString();
    }
}
