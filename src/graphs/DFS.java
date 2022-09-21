package graphs;

import java.util.ArrayList;
import java.util.Arrays;

/***
 @author: Pratiksha Kulkarni
 date: 9/21/2022
 */
public class DFS {
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> result, boolean[] vis) {

        //add the node into the output
        result.add(node);

        //mark the node ad visited
        vis[node] = true;

        for (Integer neighbour : adj.get(node)) {
            if (!vis[neighbour]) {
                dfs(neighbour, adj, result, vis);
            }
        }


    }


    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here

        //create a visited array for each vertex
        boolean[] vis = new boolean[V];
        //defalut all false;
        Arrays.fill(vis, false);


        //output array
        ArrayList<Integer> result = new ArrayList<>();

        //call dfs
        dfs(0, adj, result, vis);

        return result;
    }
}
