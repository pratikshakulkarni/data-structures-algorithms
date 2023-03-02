package trees.binaryTree;

import trees.Node;

import java.util.*;

public class PreOrderTraversal {

    private static void preOrderRecursive(Node root){
        if(root==null) return;

        System.out.print(root.data + " ");
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }

    private static void preOrderIteratively(Node root){
        Stack<Node> st = new Stack<>();
        st.push(root);


        while(!st.isEmpty()){
            Node cur = st.pop();

            System.out.print(cur.data + " ");

            if(cur.left != null) st.push(cur.left);
            if(cur.right != null) st.push(cur.right);
        }
    }

    public static void main(String[] args) {
        Node root = CreateBt.createTree();
        System.out.println("\n Recursive Approach :");
        preOrderRecursive(root);
        System.out.println("\n Iterative Approach :");
        preOrderIteratively(root);
    }

}