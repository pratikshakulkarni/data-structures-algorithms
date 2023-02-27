package queue;

import java.util.Stack;

/***
 @author: Pratiksha Kulkarni
 date: 2/27/2023
 */

class QueueS {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    void insert(int item) {
        input.push(item);
    }

    int remove() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
            return output.pop();
        } else {
            return output.pop();
        }
    }

    int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty())
                output.push(input.pop());
            return output.pop();
        } else {
            return output.pop();
        }
    }
}

public class ImplementQueueUsingStack {
 public static void main(String[] args) {
  QueueS queueS = new QueueS();

  queueS.insert(1);
  queueS.insert(2);
  queueS.insert(3);
  queueS.insert(4);
  System.out.println(queueS.remove());
  System.out.println(queueS.remove());
  System.out.println(queueS.peek());
 }
}
