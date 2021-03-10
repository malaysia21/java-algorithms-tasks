package task;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    private static Map<Character, Integer> romanIntegerMap;

    static {
        romanIntegerMap = new HashMap<>();
        romanIntegerMap.put('I', 1);
        romanIntegerMap.put('V', 5);
        romanIntegerMap.put('X', 10);
        romanIntegerMap.put('L', 50);
        romanIntegerMap.put('C', 100);
        romanIntegerMap.put('D', 500);
        romanIntegerMap.put('M', 1000);
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToIntSolution2("LVIII"));
        System.out.println(romanToIntSolution2("MCMXCIV"));
    }

    private static int romanToInt(String s) {
        int stringLength = s.length();
        int result = 0;

        for (int i = 0; i < stringLength; i++) {
            Character current = s.charAt(i);

            if (i < stringLength - 1) {
                char next = s.charAt(i + 1);

                if (romanIntegerMap.get(current) < romanIntegerMap.get(next)) {
                    result += romanIntegerMap.get(next) - (romanIntegerMap.get(current));
                    i++;
                } else {
                    result += romanIntegerMap.get(current);
                }
            } else {
                result += romanIntegerMap.get(current);
            }
        }
        return result;
    }

    private static int romanToIntSolution2(String s) {
        return romanToIntRecursion(s, 0, s.length() - 1);
    }

    private static int romanToIntRecursion(String s, int prev, int index) {
        if (index < 0)
            return 0;

        int result = romanIntegerMap.get(s.charAt(index));

        if (prev > result)
            return romanToIntRecursion(s, result, index - 1) - result;
        else
            return result + romanToIntRecursion(s, result, index - 1);
    }
}
