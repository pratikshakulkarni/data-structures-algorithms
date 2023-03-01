package trees.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/***
 @author: Pratiksha Kulkarni
 date: 1/7/2023
 */


public class PostOrderTraversal {
    private static void postOrderRecursively(Node root) {
        if (root == null) return;
        postOrderRecursively(root.left);
        postOrderRecursively(root.right);
        System.out.print(" " + root.data);
    }

    private static void postOrderIteratively(Node root) {

        Stack<Node> st = new Stack<>();
        Node prev = null;

        if (root == null) return;

        while (!st.isEmpty() || root != null) {
            if (root != null) {
                st.push(root);
                root = root.left;
            } else {
                root = st.peek();
                if (root.right == null || root.right == prev) {
                    System.out.print(" " + st.pop().data);
                    prev = root;
                    root = null;
                } else root = root.right;
            }

        }
    }

    public static void main(String[] args) {
        Node root = CreateBt.createTree();
        System.out.println("Recursive approach ");
        postOrderRecursively(root);
        System.out.println("Iterative approach ");
        postOrderIteratively(root);
    }
}
