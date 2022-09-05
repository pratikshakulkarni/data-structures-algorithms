package linkedList;

/***
 @author: Pratiksha Kulkarni
 date: 9/5/2022
 */
public class SinglyLinkedList {

    private Node head;

    class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public void insert(int x) {
        Node insertNode = new Node(x);
        Node node = head;
        if (head == null) {
            head = insertNode;
        } else {
            while (node.next != null) {
                node = node.next;
            }
            node.next = insertNode;
        }

    }

    public void insertFront(int x){
     Node temp = new Node(x);
     temp.next=head;
     head=temp;
    }

    public void insertMiddle(int x,int search){
     Node newNode = new Node(x);
     Node temp = head;
     while(temp.data!=search){
      temp=temp.next;
     }
     newNode.next=temp.next;
     temp.next=newNode;
    }

    public int deleteHead() {
        Node deleteNode;
        if (head == null) {
            System.out.println("List is empty");
            return 0;
        } else {
            deleteNode = head;
            head = head.next;
        }
        return deleteNode.data;
    }

    public int deleteEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return 0;
        }
        Node temp = head;
        Node deleteNode;// = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        deleteNode = temp.next;
        temp.next = null;
        return deleteNode.data;

    }

    public int deleteMiddleElement(int i) {
     Node temp = head;

     while(temp.next.data!=i){
      temp=temp.next;
     }
     Node deleteNode = temp.next;
     temp.next=deleteNode.next;
     return deleteNode.data;
    }

    public void traverse() {
        Node node = head;
        while (node.next != null) {
            System.out.println(node.data + " ");
            node = node.next;
        }
        System.out.println(node.data + " ");
    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        System.out.println("Sll: ");
        singlyLinkedList.insert(10);
        singlyLinkedList.insert(20);
        singlyLinkedList.insert(30);
        singlyLinkedList.insert(40);
        singlyLinkedList.insert(50);
        singlyLinkedList.insertFront(100);
        singlyLinkedList.insertMiddle(300,30);
        singlyLinkedList.traverse();
        System.out.println("delete head");
        singlyLinkedList.deleteHead();
        singlyLinkedList.traverse();
        singlyLinkedList.deleteEnd();
        System.out.println("delete end");
        singlyLinkedList.traverse();
        System.out.println("Delete middle");
        singlyLinkedList.deleteMiddleElement(30);
        singlyLinkedList.traverse();
    }
}
