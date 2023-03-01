package trees.binaryTree;

import java.util.*;

/***
 @author: Pratiksha Kulkarni
 date: 2/28/2023
 */
class TNode{
 int data;
 TNode left;
 TNode right;
 int hd;

    public TNode(int data, TNode left, TNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
public class BottomViewOfBt {
    public ArrayList<Integer> bottomView(TNode root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<TNode> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        root.hd = 0;
        q.offer(root);

        while (!q.isEmpty()) {
            TNode node = q.poll();
            int v = node.hd;

            map.put(v, node.data);

            if (node.left != null) {
                node.left.hd = v - 1;
                q.add(node.left);
            }
            if (node.right != null) {
                node.right.hd = v + 1;
                q.add(node.right);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            list.add(entry.getValue());

        return list;
    }
}
