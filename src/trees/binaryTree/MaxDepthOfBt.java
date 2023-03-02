package trees.binaryTree;

import trees.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/***
 @author: Pratiksha Kulkarni
 date: 3/2/2023
 */
public class MaxDepthOfBt {
    private static void maxDepthUsingLevelOrderTraversal(Node root) {
        if (root == null) return;

        List<List<Integer>> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);

        int height = 0;

        while (!q.isEmpty()) {
            int n = q.size();
            height++;
            List<Integer> subList = new ArrayList<>();
            for(int i=0;i<n;i++){
                Node temp = q.poll();
                subList.add(temp.data);
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
            list.add(subList);
        }
        list.forEach(System.out::println);
        System.out.println("Height " + height);
    }

    private static int maxDepthUsingRecursion(Node root){
        if(root == null) return 0;

        int lh = maxDepthUsingRecursion(root.left);
        int rh = maxDepthUsingRecursion(root.right);

        return 1+Math.max(lh,rh);
    }
    public static void main(String[] args) {
        Node root = CreateBt.createTree();

        System.out.println("\n Max depth Using Level order traversal : ");
        maxDepthUsingLevelOrderTraversal(root);

        System.out.println("\n Max depth Using Recursion : ");
        System.out.println(maxDepthUsingRecursion(root));
    }
}
