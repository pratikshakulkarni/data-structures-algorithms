package queue;

/***
 @author: Pratiksha Kulkarni
 date: 9/5/2022
 */
public class Queue {
    int[] queue;
    int front;
    int rear;

    public Queue() {
        queue = new int[10];
        front = rear = -1;
        System.out.println("Queue is created " + queue.length + " " + front + " " + rear);
    }

    public void enqueue(int x) {
        if (!isFull()) {
            front++;
            queue[front] = x;
        } else
            System.out.println("Queue is full");
    }

    public int dequeue() {
        int x = 0;
        if (!isEmpty()) {
            rear++;
            x = queue[rear];
            return x;
        } else {
            System.out.println("Queue is empty");
            return x;
        }

    }

    private boolean isFull() {
        return front == queue.length - 1;
    }

    private boolean isEmpty() {
        return front == -1;
    }

    public void printQueue(int[] queue) {
        for (int i : queue)
            System.out.println(i + " ");
    }

    public int rear() {
        return queue[rear];
    }

    public int front() {
        return queue[front];
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        for (int i = 1; i <= 10; i++)
            queue.enqueue(i);
    }
}
