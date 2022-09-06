package stack;

import java.util.Stack;

/***
 @author: Pratiksha Kulkarni
 date: 9/6/2022
 */
public class EvaluatePostfixExpression {

    private static boolean isNumber(char ch) {
        return (ch >= '0' && ch <= '9');
    }

    private static void CalculationUtility(Stack<Integer> stack, char c) {
        int val1 = stack.pop();
        int val2 = stack.pop();
        switch (c) {
            case '+': {
                stack.push(val2 + val1);
                break;
            }
            case '-': {
                stack.push(val2 - val1);
                break;
            }
            case '*': {
                stack.push(val2 * val1);
                break;
            }
            case '/': {
                stack.push(val2 / val1);
                break;
            }
        }
    }

    private static int evaluatePostfixExp(String exp) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (isNumber(ch))
                stack.push(ch - '0');
            else {
                CalculationUtility(stack, ch);
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        String exp = "231*+9-";
        System.out.println("Result : " + evaluatePostfixExp(exp));
    }
}
