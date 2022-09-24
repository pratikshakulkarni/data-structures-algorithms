package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/***
 @author: Pratiksha Kulkarni
 date: 9/24/2022
 */
public class KahnsAlgorithmTopologicalSort {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        Queue<Integer> q = new LinkedList<>();

        Arrays.fill(indegree, 0);

        for (int i = 0; i < V; i++) {
            for (int n : adj.get(i)) {
                indegree[n]++;
            }
        }

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int[] topo = new int[V];
        int k = 0;

        while (!q.isEmpty()) {
            Integer j = q.remove();
            topo[k++] = j;

            for (int it : adj.get(j)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    q.add(it);
            }

        }
        return topo;
    }
}
