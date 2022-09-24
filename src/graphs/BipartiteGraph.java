package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/***
 @author: Pratiksha Kulkarni
 date: 9/24/2022
 */
public class BipartiteGraph {
    /***
     * Bipartite graph is the one where, if we color the graph and there are no such adjacent nodes with
     * same solor then it is a bipartite graph.
     *
     * 1. Even length cycle and linear graphs are always bipartite
     */

    class Solution {
        public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
            int color[] = new int[V];
            Arrays.fill(color, -1);

            //Traverse throught all nodes if node is node is not colored pass it to BFS to color it
            for (int i = 0; i < V; i++) {
                if (color[i] == -1) {
                    // not colored
                    if (!checkBipartite(color, adj, i))
                        return false;
                }
            }
            return true;
        }

        private boolean checkBipartite(int[] color, ArrayList<ArrayList<Integer>> adj, int start) {
            Queue<Integer> q = new LinkedList<>();
            color[start] = 0;
            q.add(start);

            while (!q.isEmpty()) {
                Integer node = q.poll();
                for (Integer n : adj.get(node)) {
                    //neighbour of the node in queue -- check if it is colored or not
                    if (color[n] == -1) {
                        //not colored
                        color[n] = (color[node] == 0) ? 1 : 0;
                        q.add(n);
                    } else if (color[n] == color[node]) {
                        //neighbour of node was already colored by someone else
                        //& both colors on node and n are same so return false
                        //not bipartite
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean checkBipartiteDFS(int[] color, int startColor, ArrayList<ArrayList<Integer>> adj, int start) {
            color[start] = startColor;

            for (int i : adj.get(start)) {
                if (color[i] == -1) {
                    //not colored
                    int newColor = (color[start] == 0) ? 1 : 0;
                    if (!checkBipartiteDFS(color, newColor, adj, i)) return false;
                } else if (color[i] == startColor) {
                    return false;
                }
            }
            return true;
        }
    }
}
