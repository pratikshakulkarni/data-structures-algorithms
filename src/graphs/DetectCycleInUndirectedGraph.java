package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/***
 @author: Pratiksha Kulkarni
 date: 9/21/2022
 */
public class DetectCycleInUndirectedGraph {
    class Pair {
        int node;
        int parent;

        public Pair(int _node, int _parent) {
            this.node = _node;
            this.parent = _parent;
        }
    }

    private boolean hasCycle(boolean[] vis, int node, ArrayList<ArrayList<Integer>> adj) {

        vis[node] = true;
        //Queue
        Queue<Pair> q = new LinkedList<>();
        //root-- starting node
        q.add(new Pair(node, -1));

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int data = p.node;
            int parent = p.parent;

            for (Integer i : adj.get(data)) {
                if (!vis[i]) {
                    vis[i] = true;
                    q.add(new Pair(i, data));
                }
                //visited but not parent means cyle
                else if (parent != i) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        //create a vis array
        boolean[] vis = new boolean[V];
        Arrays.fill(vis, false);

        //traverse through each node and check bfs
        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                if (hasCycle(vis, i, adj))
                    return true;
            }
        }
        return false;
    }
}
