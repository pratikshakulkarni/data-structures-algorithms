# data-structures-algorithms

---
## Trees: 


---
## Graphs

### Types:
- Undirected graphs UDG
- Directed graphs DG

### Conventions:
1. Node/Vertex/V
2. Edges/- connects 2 vertices
3. undirected edge - bi-direction
4. Directed edge - uni-directed (separate for other way around)
5. Cycles - If we start from a vertex and end at the same node is a cycle in a graph.
6. Trees are a special graphs with no cycles.
7. Path - Contains a lot of nodes and each of them is reachable  - no duplicate nodes in a path.
8. Degrees - count of the incoming and outgoing edges of a node.

### Properties:
1. Total degree of a graph = 2 * E (UDG)
2. DG had in-degree and out-degree - in-degree count of incoming edges and out-degree as number of outgoing edges.
3. Edge weight - each edge has a weight assigned, if not assume it as unit i.e. 1.

### Graph representation:
1. Adjacency List: It is a list of lists, where there is a list of nodes and for each node there is a list of its neighbor.
2. Adjacency Matrix:
   For a graph of # of Nodes V and Edges E, matrix is of size V*V where adj[i][j] == 1 of there exists a node between node i and node j and vice versa as graph is undirected graph.
   If adj[i][j] = w, then there is an edge from vertex i to vertex j with weight w.
   Time complexity is O(V^2)
3. Note: if graph is 1 based matrix size is adj[V+1][V+1], if 0 based it is adj[v][v]==

### Connected Components: 
separate looking graph can also be considered as connected components, as they are a part of same graph
without direct connection.
When dealing with such type of graphs,
```
-use a visited array depending upon the V
-Run a loop for each v in V
-if v is unvisited start traversal
-mark v as visited.
```

### Graph Traversal
1. Breadth first search - (BFS)
   level wise traversal.

   - the starting node is considered as a level 0 node.
   - nodes at a distance of 1 from the starting node are considered as level 1
   - nodes at a distance of 2 from the starting node are considered as level 2
   .
   .
   - Starting node can be any node, not necessary it has to be a root node.
   
```
Algorithm:
1. Use a Queue which already has the starting node.
2. Use a visited array, where each node is initially not visited (-1), mark the starting node a 1.
3. While(q is not empty)
	3.1 dequeue the node 'e' --starting node for the first time.
	3.2 for each neighbor n of e, if n is not visited enqueue n in the queue
	3.3 mark n in visisted array as 1 i.e. visited.
4. return

SC: O(n)
TC: O(n) + O(2E)
```
2. Depth first search - DFS
   depth vise traversal of each node.

   start from the given starting node, visit is neighbor n
   traverse the n i.e. go the n's neighbor.
   Continue until there is no neighbor left then return to the calling node, reaching the starting node and explore the other path.
   Use the same visited array concept, if already visited do not traverse, else mark it visited and traverse further.

   **DFS is RECURSIVE**
 ```  
Algorithm

dfs(node){
    vis[node]=1;
    for each(neighbor of node 'e'){
        if(vis[e] is not visisted){
            dfs(e)
        }
    }
}

SC: O(n)
TC: O(n)+O(2E)
```

### CYCLE DETECTION

1. Detect a cycle in an undirected graph using BFS:
   Starting in 2 different directions and colliding at the same node which means cycle exists.

```
Initial configurations:
the que will store pair of (node,parent)
Algorithm:
1 enqueue pair(startNode,-1) into the queue.
2. mark startNode as visited
3. while(q is not empty){
   pop element 'e'
   node = e.node
   parent = e.parent

   for(each neighbor of node - n){
   if(vis[n] is 0 i.e unvisited){
   enqueue(pair(n,node))
   }
   else if(parent !n){
   //this is the colliding point which is already visisted but not parent means cycle
   return true;
   }
   }
   }
   //If true is never returned means no cylce was found so return false
4. return false;

SC- O(n)
TC- O(n+2E)
//for components
O(n+2e)+O(n)
```

2. Detect a cycle in undirected graph using DFS:

```
Algorithm:

boolean dfs(node){
vis[node]=1;

	foreach(neighbor n of node ){
		if(n is not visited){
			boolean res = dfs(n)
			if(res==true)
				return true;
		}
		n is visited
		else if(n is not equal to node.parent){
			return true;
		}
	}
	return false;
}

SC- O(n)
TC- O(n+2E)
//for components
O(n+2e)+O(n)
```

### Topological sort using DFS
Topological Sort : linear ordering of vertices such that there is an edge between u & v u->v. 'v' appears before 'u'.
Only applicable for DAG.

#### Steps:
1. Run a loop for each vertex
2. for each vertex, if it is not visited start dfs(node)
3. In dfs - mark node as visited,
4. Check if node has any neighbour keep traversing till no neighbour is found.
5. Push the node without neighbor into the stack.
6. Follow this fo each non visited node.
7. Pop all the elements from stack - the sequence is the topological sort.

```
for(each node){
    dfs(node,vis,stack);
}
dfs(node,vis,stack){
    vis[node]=1;
     for (int i : adj.get(node)) {
        if (vis[i] == 0) {
           dfs(i, vis, stack, adj);
        }
     }
    stack.push(node);
}
```

### Kahn's Algorithm | BFS Topological Sort





