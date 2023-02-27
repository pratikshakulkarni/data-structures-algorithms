package linkedList;

/***
 @author: Pratiksha Kulkarni
 date: 9/5/2022
 */
public class CircularLinkedList {

    Node head;
    Node tail;

    private class Node {
        int data;
        Node next;

        public Node(int x) {
            this.data = x;
            next = null;
        }
    }

    public void insertHead(int x) {
        //create a new node with data
        Node node = new Node(x);

        //check if head is null
        if (head == null) {
            //if head is null then we are inserting first element in CLL
            head = node;
            tail = node;
        } else {
            //else we will insert it at heads place
            tail.next = node;
            node.next = head;
            tail = node;
        }

    }

    public void insertTail(int x) {
        Node node = new Node(x);

        node.next=tail.next;
        tail.next=node;
        tail=node;
    }


    public static void main(String[] args) {

    }
}
