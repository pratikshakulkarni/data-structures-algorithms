package trees.binaryTree;

import java.util.*;

/***
 @author: Pratiksha Kulkarni
 date: 2/28/2023
 */
class Pair {
    Node node;
    int ver;

    public Pair() {
    }

    public Pair(Node _node, int _ver) {
        node = _node;
        ver = _ver;
    }
}

public class TopViewOfBT {
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair temp = q.poll();
            int v = temp.ver;
            Node node = temp.node;

            if (map.get(v) == null) map.put(v, node.data);

            if (node.left != null)
                q.add(new Pair(node.left, v - 1));

            if (node.right != null)
                q.add(new Pair(node.right, v + 1));
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            list.add(entry.getValue());

        return list;
    }
}
