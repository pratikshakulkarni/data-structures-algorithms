package trees;

/***
 @author: Pratiksha Kulkarni
 date: 3/1/2023
 */
public class Node {
    Node left;
    Node right;
    int data;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
        left = right = null;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return this.data;
    }
}
