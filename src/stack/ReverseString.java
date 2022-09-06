package stack;

import java.util.Stack;

/***
 @author: Pratiksha Kulkarni
 date: 9/6/2022
 */
public class ReverseString {
 private static String reverse(String stringToReverse){
  StringBuilder sb = new StringBuilder();
  Stack<Character> stack = new Stack<>();
  for(int i=0;i<stringToReverse.length();i++)
   stack.push(stringToReverse.charAt(i));

  while(!stack.isEmpty())
   sb.append(stack.pop());

  return sb.toString();
 }

 public static void main(String[] args) {
  String s = "hi";
  System.out.println("String - " + s + " Reversed string - " +reverse(s) );
 }
}
