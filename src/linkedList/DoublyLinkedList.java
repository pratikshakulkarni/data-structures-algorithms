package linkedList;

/***
 @author: Pratiksha Kulkarni
 date: 9/5/2022
 */
public class DoublyLinkedList {
    private Node head;
    private class Node{
        int data;
        Node prev;
        Node next;

        public Node(int data){
            this.data=data;
            this.prev=null;
            this.next=null;
        }
    }

    public void insertFirst(int x){
        Node newNode = new Node(x);
        if(head==null)
            head=newNode;
        else{
            head.prev=newNode;
            newNode.next=head;
            head=newNode;
        }
    }

    public void insertLast(int x){
        Node newNode = new Node(x);

        if(head==null)
            head=newNode;
        else{
            Node node = head;
            while(node.next != null)
                node=node.next;

            node.next=newNode;
            newNode.prev=node;
        }
    }

    public void insertMiddle(int search, int data){
        Node newNode = new Node(data);

        if(head == null)
            head=newNode;
        else{
            Node node = head;
            while (node.data  != search){
                node=node.next;
            }
            newNode.next=node.next;
            newNode.prev=node;
            node.next=newNode;
            newNode.next.prev=newNode;
        }
    }

    public int deleteLast(){
        Node node;
        int x=0;
        if(head == null)
            System.out.println("DLL is empty ");
        else if(head.next == null){
            x=head.data;
            head=null;
        }
        else {
            node = head;
            while (node.next != null) {
                node = node.next;
            }
            x=node.data;
            node.prev.next=null;
            node.next=null;
        }

        return x;
    }

    public int deleteFirst(){
        int x=0;

        if(head==null)
            System.out.println("DLL is empty ");
        else if(head.next == null){
            x=head.data;
            head=null;
        }else{
            Node node = head;
            head=node.next;
            head.prev=null;
            x=node.data;
            node=null;
        }


        return x;
    }

    public int deleteAnElement(int element){
        int x=0;
        if(search(element)){
            Node node = head;
            while(node.data  != element){
                node=node.next;
            }
            x=node.data;
            //delete the head
            if(node==head)
                head=null;
            else{
                //node had the element should be deleted
                //node to be deleted
                node.prev.next=node.next;
                node.next.prev=node.prev;
                node=null;
            }

        }
        else{
            System.out.println("Cannot delete as element not found");
        }
        return x;
    }

    public boolean search(int x){
        Node node;

        if(head==null)
            System.out.println("DLL is empty ");
        else{
            node=head;
            while(node != null){
                if(node.data==x)
                    return true;
                node= node.next;
            }
        }
        return false;
    }

    public void display(){
        System.out.println("Print");
        Node node = head;
        Node revNode=null;

        while(node != null){
            System.out.print(node.data+" -> ");
            revNode=node;
            node=node.next;
        }
        System.out.println("END");

        System.out.println("Printing in reverse ");
        while(revNode  != null){
            System.out.print(revNode.data + " -> ");
            revNode=revNode.prev;
        }
        System.out.println("START");
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertFirst(10);
        dll.insertFirst(17);
        dll.insertFirst(85);
        dll.insertLast(585);
        dll.insertMiddle(17,100);
        dll.display();
        System.out.println("After deletion");
        dll.deleteLast();
        dll.display();
        dll.deleteFirst();
        dll.display();
        System.out.println("delete an element");
        dll.deleteAnElement(100);
        dll.display();
        System.out.println("Search 17 " + dll.search(17));
    }
}
