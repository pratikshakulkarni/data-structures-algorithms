package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/***
 @author: Pratiksha Kulkarni
 date: 9/21/2022
 */
public class BFS {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here

        //Queue to taverse through the vertices
        Queue<Integer> nodes = new LinkedList<>();

        //output array
        ArrayList<Integer> result = new ArrayList<>();

        //Visited array to for each vertex. Initialize it with 0
        int[] vis = new int[V + 1];
        Arrays.fill(vis, 0);

        //insert the starting vertex into the Queue and mark it as visited
        nodes.add(0);
        vis[0] = 1;

        while (!nodes.isEmpty()) {
            Integer currentVertex = nodes.poll();
            result.add(currentVertex);

            for (Integer i : adj.get(currentVertex)) {
                if (vis[i] == 0) {
                    nodes.add(i);
                    vis[i] = 1;
                }
            }

        }

        return result;
    }
}
