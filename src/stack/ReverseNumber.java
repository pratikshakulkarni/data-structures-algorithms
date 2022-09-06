package stack;

import java.util.Stack;

/***
 @author: Pratiksha Kulkarni
 date: 9/6/2022
 */
public class ReverseNumber {
    private static void reverseNumber(Long l) {
        long mod = 0;
        long reverse = 0, i = 1;
        Stack<Long> stack = new Stack<>();
        while (l != 0) {
            mod = l % 10;
            l = l / 10;
            stack.push(mod);
        }

        while (!stack.isEmpty()) {
            reverse = reverse + (stack.peek() * i);
            stack.pop();
            i = i * 10;
        }
     System.out.println("Reverse : " +reverse);
    }

    public static void main(String[] args) {
        long number = 1997;
        reverseNumber(number);
    }
}
