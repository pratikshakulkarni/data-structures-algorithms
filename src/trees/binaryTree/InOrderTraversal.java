package trees.binaryTree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/***
 @author: Pratiksha Kulkarni
 date: 1/7/2023
 */

public class InOrderTraversal {

    public static void inOrderRec(Node root) {
        if (root == null)
            return;

        inOrderRec(root.left);
        System.out.print(root.data + " ");
        inOrderRec(root.right);
    }

    public static void inOrderIterative(Node root) {
        Stack<Node> st = new Stack<>();

        Node curr = root;
        st.push(curr);
        curr = curr.left;

        while (!st.isEmpty() || curr != null) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }

            curr = st.pop();
            System.out.print(curr.data+ " ");
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        Node root = CreateBt.createTree();
        System.out.println("Inorder Iteratively : ");
        inOrderIterative(root);
    }
}
