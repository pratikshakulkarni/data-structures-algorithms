package stack;

/***
 @author: Pratiksha Kulkarni
 date: 9/6/2022
 */
public class TwoStacks {

    int[] array;
    int top1, top2;
    int capacity;

    public TwoStacks(int capacity) {
        this.capacity = capacity;
        array = new int[capacity];
        top1 = top2 = -1;
    }

    public void insertUtility(int x) {
        //all evens in array 1
        if (x % 2 == 0)
            push1(x);
            //all odds in array 2
        else
            push2(x);
    }

    private void push1(int x) {
        if (!isFull(top1))
            array[++top1] = x;
        else
            System.out.println("Stack1 is full");
    }

    private void push2(int x) {
        if (!isFull(top2))
            array[++top2] = x;
        else
            System.out.println("Stack1 is full");
    }

    private boolean isFull(int top) {
        return (top == array.length - 1);
    }

    private boolean isEmpty(int top) {
        return (top == -1);
    }

    public int pop1() {
        if (!isEmpty(top1))
            return array[top1++];
        else {
            System.out.println("Stack1 is empty");
            return -1;
        }
    }

    public int pop2() {
        if (!isEmpty(top2))
            return array[top2++];
        else {
            System.out.println("Stack2 is empty");
            return -1;
        }
    }

    public static void main(String[] args) {
        TwoStacks twoStacks = new TwoStacks(20);

        twoStacks.insertUtility(10);
        twoStacks.insertUtility(5);
        twoStacks.insertUtility(20);
        twoStacks.insertUtility(13);
        twoStacks.insertUtility(1);

        System.out.println(twoStacks.pop1());
        System.out.println(twoStacks.pop2());
    }

}
