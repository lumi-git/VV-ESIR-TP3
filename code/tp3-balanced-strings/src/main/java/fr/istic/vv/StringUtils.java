package fr.istic.vv;

import java.util.ArrayList;
import java.util.Stack;

public class StringUtils {

    private StringUtils() {}

    public static boolean isBalanced(String s) {
        Stack<String> stack = new Stack<String>();
        for (char l : s.toCharArray()) {

            if (l == '(' || l == '{' || l == '[') {
                stack.add(l);
            }
            else if (l == ')') {
                if (stack.isEmpty() || stack.getLast() != '(') {

                    return false;
                }
                stack.removeLast();
            }
            else if (l == '}') {
                if (stack.isEmpty() || stack.getLast() != '{') {

                    return false;
                }
                stack.removeLast();
            }
            else if (l == ']') {
                if (stack.isEmpty() || stack.getLast() != '[') {
                    return false;
                }
                stack.removeLast();
            }

        }
        return stack.isEmpty();

    }

}
