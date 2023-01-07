package trees.binaryTree;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

/***
 @author: Pratiksha Kulkarni
 date: 1/7/2023
 */

class InNode {
    int data;
    InNode left, right;
    InNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
    InNode() {

    }
}
public class InOrderTraversal {

    public void inOrder(InNode root, List<Integer> list){

        if(root == null){
            return;
        }
        else{
            inOrder(root.left,list);
            list.add(root.data);
            inOrder(root.right,list);
        }
    }

    public static void main(String[] args) {
        List<Integer> inResult = new ArrayList<>();

        InNode root = new InNode(1);
        root.left = new InNode(2);
        root.right = new InNode(3);
        root.left.left = new InNode(4);
        root.left.right = new InNode(5);
        root.right.left = new InNode(6);
        root.right.right = new InNode(7);
        root.left.right.left = new InNode(8);

        InOrderTraversal inOrderTraversal = new InOrderTraversal();

        inOrderTraversal.inOrder(root,inResult);

        System.out.println("Traversal : ");
        System.out.println(inResult);

    }



}
