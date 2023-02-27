package stack;

import java.util.Stack;

/***
 @author: Pratiksha Kulkarni
 date: 2/27/2023
 */
public class BalancedParenthesis {

    private static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                else {
                    char temp = stack.pop();
                    if ((c == ')' && temp == '(') || (c == '}' && temp == '{') || (c == ']' && temp == '[')) continue;
                    else return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
     System.out.println(isBalanced("}"));
    }
}
