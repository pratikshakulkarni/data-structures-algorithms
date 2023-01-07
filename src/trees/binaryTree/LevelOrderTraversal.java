package trees.binaryTree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/***
 @author: Pratiksha Kulkarni
 date: 1/7/2023
 */

class LevelNode {
    int data;
    LevelNode left, right;

    LevelNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    LevelNode() {

    }
}

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(LevelNode root) {
        //Declare a Queue to store all the nodes in level wise
        Queue<LevelNode> q = new LinkedList<>();
        List<List<Integer>> flist = new LinkedList<List<Integer>>();

        if (root == null) return flist;
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> slist = new LinkedList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                if (q.peek().left != null) q.offer(q.peek().left);
                if (q.peek().right != null) q.offer(q.peek().right);
                slist.add(q.poll().data);
            }
            flist.add(slist);
        }
        return flist;
    }

    public static void main(String[] args) {

        List<List<Integer>> flist = new LinkedList<List<Integer>>();
        LevelNode root = new LevelNode(1);
        root.left = new LevelNode(2);
        root.right = new LevelNode(3);
        root.left.left = new LevelNode(4);
        root.left.right = new LevelNode(5);
        root.right.left = new LevelNode(6);
        root.right.right = new LevelNode(7);
        root.left.right.left = new LevelNode(8);

        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        flist = levelOrderTraversal.levelOrder(root);


        System.out.println("Traversal : ");
        System.out.println(flist);
    }
}

