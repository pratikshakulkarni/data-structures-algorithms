package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/***
 @author: Pratiksha Kulkarni
 date: 9/24/2022
 */
public class CycleInDirectedGraph {
 /***
  * In directed graph the regular dfs will not work as there might be a case where the node will be visited from another path
  * and it will meet it and return true.
  * So we maintain a pathVisited array where even if any node is previously visited and had not path visited then that route can be further traverse.
  * PathVisited is also undone in each iteration -- i.e. it is backtracked to 0
  */

 class Solution {
  // Function to detect cycle in a directed graph.
  public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
   int[] vis = new int[V];
   int pathVisited[] = new int[V];
   System.out.println("BFS " + hasCycleBfs(V,adj));
   Arrays.fill(vis, 0);
   Arrays.fill(pathVisited, 0);

   for (int i = 0; i < V; i++) {
    if (vis[i] == 0) {
     if (hasCycleDfs(i, vis, pathVisited, adj))
      return true;
    }
   }
   return false;
  }

  private boolean hasCycleDfs(int start, int[] vis, int[] pathVisited, ArrayList<ArrayList<Integer>> adj) {
   vis[start] = 1;
   pathVisited[start] = 1;

   for (int i : adj.get(start)) {
    if (vis[i] == 0) {
     if (hasCycleDfs(i, vis, pathVisited, adj)) return true;
    } else if (pathVisited[i] == 1)
     return true;
   }

   pathVisited[start] = 0;
   return false;
  }
 }

 private boolean hasCycleBfs(int V, ArrayList<ArrayList<Integer>> adj) {
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

  int k = 0;

  while (!q.isEmpty()) {
   Integer j = q.remove();
   k++;

   for (int it : adj.get(j)) {
    indegree[it]--;
    if (indegree[it] == 0)
     q.add(it);
   }

  }
  return k != V;


 }
}
