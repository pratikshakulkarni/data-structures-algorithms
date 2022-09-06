package stack;
import java.util.Stack;

/***
 @author: Pratiksha Kulkarni
 date: 9/6/2022
 */
public class InfixToPostFix {
    private static boolean isOperand(char ch){
        return (ch>='a' && ch<='z')|| (ch>='A' && ch<='Z');
    }

    private static int precedence(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '/':
            case '*':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static String convertToPostFix(String expression){
        Stack<Character> stack = new Stack<>();
        StringBuilder postfixExpression = new StringBuilder();
        for(int i=0;i<expression.length();i++){
            char ch = expression.charAt(i);
            if(isOperand(ch))
                postfixExpression.append(ch);
            else if(ch=='('){
                stack.push(ch);
            }
            else if(ch==')'){
                while(!stack.isEmpty() && stack.peek()!='(') {
                    postfixExpression.append(stack.peek());
                    stack.pop();
                }
                stack.pop();
            }
            else{
                while(!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())){
                    postfixExpression.append(stack.peek());
                    stack.pop();
                }
                stack.push(ch);
            }
    }
        while (!stack.isEmpty()) {
            if (stack.peek() == '(')
                return "Invalid Expression";
            postfixExpression.append(stack.peek());
            stack.pop();
        }

        return postfixExpression.toString();
    }

    public static void main(String[] args) {
        System.out.println("Postfix :" + convertToPostFix("a+b*(c^d-e)^(f+g*h)-i"));
    }

}
