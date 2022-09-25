package graphs;

import java.util.ArrayList;
import java.util.Stack;

/***
 @author: Pratiksha Kulkarni
 date: 9/26/2022
 */
public class DAGShortestDistanceTopologicalSort {
    /***
     * 1. get the topological sort
     * 2. calculate the distance for each popping element from the stack
     * 3. return the distance array
     */
    private class Pair {
        int title;
        int weight;

        public Pair(int i, int wt) {
            this.title = i;
            this.weight = wt;
        }
    }

    private void topoSort(int node, int[] vis, Stack<Integer> stack, ArrayList<ArrayList<Pair>> adj) {
        vis[node] = 1;
        for (int i = 0; i < adj.get(node).size(); i++) {
            int title = adj.get(node).get(i).title;
            if (vis[title] == 0) {
                topoSort(title, vis, stack, adj);
            }
        }
        stack.push(node);
    }

    private int[] claculateDistanceFromSource(Stack<Integer> stack, ArrayList<ArrayList<Pair>> adj, int N) {
        int[] distance = new int[N];
        for (int i = 0; i < N; i++)
            distance[i] = (int) 1e9;

        distance[0] = 0;
        while (!stack.isEmpty()) {
            Integer node = stack.pop();
            for (int i = 0; i < adj.get(node).size(); i++) {
                int v = adj.get(node).get(i).title;
                int wt = adj.get(node).get(i).weight;

                if (distance[node] + wt < distance[v]) {
                    distance[v] = distance[node] + wt;
                }
            }
        }
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == (int) 1e9)
                distance[i] = -1;
        }
        return distance;
    }

    public int[] shortestPath(int N, int M, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<Pair>());
        }
        for (int i = 0; i < M; i++) {
            int j = edges[i][0];
            int p = edges[i][1];
            int wt = edges[i][2];
            adj.get(j).add(new Pair(p, wt));
        }
        int[] vis = new int[N];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (vis[i] == 0)
                topoSort(i, vis, stack, adj);
        }
        //Now graph is topologically sorted
        //DO the distance thing
        return claculateDistanceFromSource(stack, adj, N);
    }
}
