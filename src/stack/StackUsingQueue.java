package stack;


import java.util.LinkedList;
import java.util.Queue;

/***
 @author: Pratiksha Kulkarni
 date: 2/27/2023
 */
class StackQ{
    Queue<Integer> q = new LinkedList<>();

    void push(int item){
        q.add(item);

        for(int i=0;i<q.size()-1;i++){
            q.add((q.remove()));
        }
    }

    int pop(){
        return q.remove();
    }

    int peek(){
        return q.peek();
    }
    int size(){
        return q.size();
    }
}
public class StackUsingQueue {
    public static void main(String[] args) {
        StackQ stackQ = new StackQ();

        stackQ.push(1);
        stackQ.push(2);
        stackQ.push(3);
        stackQ.push(4);
        System.out.println(stackQ.pop());
        System.out.println(stackQ.pop());
        System.out.println(stackQ.peek());
    }
}
