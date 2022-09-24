package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/***
 @author: Pratiksha Kulkarni
 date: 9/24/2022
 */
public class TopologicalSort {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(vis, 0);

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, stack, adj);
            }
        }

        int[] sort = new int[V];
        int k = 0;
        while (!stack.isEmpty()) {
            sort[k++] = stack.pop();
        }
        return sort;
    }

    private static void dfs(int node, int[] vis, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;

        for (int i : adj.get(node)) {
            if (vis[i] == 0) {
                dfs(i, vis, stack, adj);
            }
        }
        stack.push(node);
    }
}
