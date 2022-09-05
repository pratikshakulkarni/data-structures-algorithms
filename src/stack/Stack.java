package stack;

/***
 @author: Pratiksha Kulkarni
 date: 9/5/2022
 */
public class Stack {
    int[] stack;
    int top;

    public Stack() {
        stack = new int[10];
        top = -1;
        System.out.println("Stack is created with pointer :" + top);
    }

    public void push(int x) {
        if (!isFull()) {
            top++;
            stack[top] = x;
        } else
            System.out.println("Stack is full");

    }

    public int pop() {
        int x = 0;
        if (!isEmpty()) {
            x = stack[top];
            top--;
        } else {
            System.out.println("Stack is empty");
        }
        return x;
    }

    public int peek() {
        if (!isEmpty()) {
            System.out.println("Top element :: " + stack[top]);
            return stack[top];
        } else {
            System.out.println("Stack is empty");
            return 0;
        }
    }

    private boolean isEmpty() {
        return top == -1;
    }

    private boolean isFull() {
        return top == stack.length - 1;
    }

    private void printStack(int[] stack) {
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println("Pushing elements");
        for (int i = 1; i <= 10; i++)
            stack.push(i);
        stack.printStack(stack.stack);
        System.out.println();
        System.out.println("Peeking");
        stack.peek();
        System.out.println("Popping elements");
        for (int i = 0; i < stack.stack.length; i++)
            System.out.println("Popped element :: " + stack.pop());

    }
}
