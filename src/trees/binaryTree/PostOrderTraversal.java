package trees.binaryTree;

import java.util.ArrayList;
import java.util.List;

/***
 @author: Pratiksha Kulkarni
 date: 1/7/2023
 */

class PostNode {
    int data;
    PostNode left, right;
    PostNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
    PostNode() {

    }
}
public class PostOrderTraversal {

    public void postOrderTraversal(PostNode root, List<Integer> list){
        if(root==null) return;
        else{
            postOrderTraversal(root.left,list);
            postOrderTraversal(root.right,list);
            list.add(root.data);
        }
    }
    public static void main(String[] args) {

        PostOrderTraversal postOrderTraversal = new PostOrderTraversal();

        List<Integer> postList = new ArrayList<>();

        PostNode root = new PostNode(1);
        root.left = new PostNode(2);
        root.right = new PostNode(3);
        root.left.left = new PostNode(4);
        root.left.right = new PostNode(5);
        root.right.left = new PostNode(6);
        root.right.right = new PostNode(7);
        root.left.right.left = new PostNode(8);

        postOrderTraversal.postOrderTraversal(root,postList);


        System.out.println("Traversal : ");
        System.out.println(postList);
    }
}
