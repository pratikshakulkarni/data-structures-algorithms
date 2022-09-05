package linkedList;

/***
 @author: Pratiksha Kulkarni
 date: 9/5/2022
 */
public class DoublyLinkedList {
    private Node head;

    class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            prev = next = null;
            System.out.println("Doubly Linked list created");
        }
    }

    public void insertEnd(int x) {
        Node insertNode = new Node(x);
        if (head == null) {
            head = insertNode;
        } else {
            Node temp = head;
            while (temp.next == null) {
                temp = temp.next;
            }
            insertNode.prev = temp;
            temp.next = insertNode;
        }
    }

    public void traverse() {
        Node temp = head;
        while (temp.next != null) {
            System.out.println(" " + temp.data);
            temp = temp.next;
        }
        System.out.println(temp.data);
    }


}
