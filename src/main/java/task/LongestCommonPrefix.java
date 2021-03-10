package task;


public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String [] {"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String [] {"dog","racecar","car"}));

        System.out.println(longestCommonPrefixSolution2(new String [] {"flower","flow","flight"}));
        System.out.println(longestCommonPrefixSolution2(new String [] {"dog","racecar","car"}));

        System.out.println(longestCommonPrefixSolution3(new String [] {"flower","flow","flight"}));
        System.out.println(longestCommonPrefixSolution3(new String [] {"dog","racecar","car"}));
         }

    private static String longestCommonPrefix(String[] array) {
        StringBuilder result = new StringBuilder("");
        if(array.length >0 ) {
            int minLength = array[0].length();

            for (String s : array) {
                minLength = Math.min(minLength, s.length());
            }

            for (int i = 0; i < minLength; i++) {
                Character verifyingCharacter = null;
                for (String s : array) {
                    if (verifyingCharacter == null) {
                        verifyingCharacter = s.charAt(i);
                    }
                    if (verifyingCharacter != s.charAt(i)) {
                        return result.toString();
                    }
                }
                result.append(verifyingCharacter);
            }

        }
        return result.toString();
    }

    //horizontal scanning
    private static String longestCommonPrefixSolution2(String[] array) {
        if (array.length == 0) return "";
        String prefix = array[0];
        for (int i = 1; i < array.length; i++)
            while (array[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }


    private static String longestCommonPrefixSolution3(String[] array) {
        if (array == null || array.length == 0) return "";
        return longestCommonPrefixRecursive(array, 0 , array.length - 1);
    }

    private static String longestCommonPrefixRecursive(String[] array, int l, int r) {
        if (l == r) {
            return array[l];
        }
        else {
            int mid = (l + r)/2;
            String lcpLeft =   longestCommonPrefixRecursive(array, l , mid);
            String lcpRight =  longestCommonPrefixRecursive(array, mid + 1,r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    private static String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) )
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }

}
