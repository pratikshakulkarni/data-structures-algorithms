package trees.binaryTree;

import trees.Node;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/***
 @author: Pratiksha Kulkarni
 date: 1/7/2023
 */

public class LevelOrderTraversal {
    private static void levelOrder(Node root) {
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

    public static void main(String[] args) {
        Node root = CreateBt.createTree();
        System.out.println("\n Level wise traversal : ");
        levelOrder(root);
    }
}

