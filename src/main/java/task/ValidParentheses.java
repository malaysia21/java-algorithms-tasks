package task;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    private static HashMap<Character, Character> parenthesesPairMap;
    private static Map<Character, Character> parenthesesPairMap2;

    static {
        parenthesesPairMap = new HashMap<>();
        parenthesesPairMap.put(')', '(');
        parenthesesPairMap.put(']', '[');
        parenthesesPairMap.put('}', '{');

        parenthesesPairMap2 = new HashMap<>();
        parenthesesPairMap2.put('(', ')');
        parenthesesPairMap2.put('[', ']');
        parenthesesPairMap2.put('{', '}');
    }


    public static void main(String[] args) {
        System.out.println(isValid("()[]{}")); //true
        System.out.println(isValid("([)]")); //false
        System.out.println(isValid("{[]}")); //true

        System.out.println(isValidSolution2("()[]{}")); //true
        System.out.println(isValidSolution2("([)]")); //false
        System.out.println(isValidSolution2("{[]}")); //true
    }

    private static boolean isValid(String s) {
        char[] stack = new char[10000];
        int currentHead = -1;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (parenthesesPairMap.containsValue(s.charAt(i))) {
                ++currentHead;
                stack[currentHead] = s.charAt(i);
            } else {
                if (currentHead == -1 || stack[currentHead] != parenthesesPairMap.get(s.charAt(i))) {
                    return false;
                } else {
                    currentHead--;
                }
            }
        }
        return currentHead == -1;
    }

    private static boolean isValidSolution2(String s) {
        Stack<Character> parenthesis = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (parenthesesPairMap2.containsKey(c)) {
                parenthesis.push(parenthesesPairMap2.get(c));
            } else if (parenthesesPairMap2.containsValue(c)) {
                if (parenthesis.isEmpty() || parenthesis.pop() != c) {
                    return false;
                }
            }
        }
        return parenthesis.isEmpty();
    }
}
