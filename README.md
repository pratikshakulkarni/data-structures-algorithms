# data-structures-algorithms

---
## Trees: 

###
-Binary Trees
-Binary Search Tree

###
1. Node 
2. Edges
3. Leaf Nodes -> no children
4. height -> starts from root and 1
5. level -> starts from root and 0

### 
Important Formulas 

- Nodes at each level are -> (2 * i) -- where i is the level
- Maximum number of nodes in a Bt with a height h is [(2^h)-1]


### Representation of a Node
```
Node {
Node left,right;
int data;
}
```

### Type of traversals

1. Breadth First Search
- Level order Traversal (level wise)

1.1 LevelOrder Traversal
```
1. Intialize a queue of type Node
2. Insert the root into the queue
3. while the q  is not empty 
   3.1 check if q.peek().left is not null insert into queue.
   3.2 check if q.peek().right is not null insert into queue.
   3.3 add the q.pop() in resultant array
4. end

    private static void levelOrder(Node root) {
        if (root == null) return;

        List<Integer> subList = new ArrayList<>();
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);

        while (!q.isEmpty()) {
            if (q.peek().left != null) q.offer(q.peek().left);
            if (q.peek().right != null) q.offer(q.peek().right);
            subList.add(q.poll().data);
        }
        subList.forEach(System.out::print);
    }
```

2. Depth First Search 
- InOrder (Left, node, right)
- PreOrder (Node, left, right)
- PostOrder (left, right, Node)

###
2.1 InOrder Traversal:

1. Recursive Approach:
```
1. if current root is null return nothing
2. Start visiting left children recursively
3. Save the data in anu resultant array
4. Start visiting right children recursively
------------------------------------------------
inorder(Node root){
if(root == null) return
inorder(root.left);
result.add(root.data);
inorder(root.right);
}
```

2. Iterative Approach
``` 
1. Maintain a stack of type Node
2. push the root into the stack and do move to roots left i.e. root = root.left
3. Iterate till either stack is not empty or root is not null
  while(root is not null)
    push the root into stack
    root=root.left
4. out of while means root is now null so pop the top of the stack root = stack.pop();
5. traverse to the right of the root, root= root.right

```

2.2 PostOderTraversal
1. Recursive Approach
```
postorder(Node root){
if(root == null) return
postorder(root.left);
postorder(root.right);
result.add(root.data);
}
```
2. Iterative Approach 
``` 
Push all left nodes into the stack till it hits NULL.
root = s.peek()
if root.right = null or pre (Means we have traversed the right subtree already)
We print root and pop it from s.
Make pre = root
root = null (So we dont go down to left child again)
else
root = root.right (Traverse the right subtree before printing root)
Keep iterating till both the below conditions are met -
Stack is empty and
Root is NULL.
```
```  
private static void postOrderIteratively(Node root) {

        Stack<Node> st = new Stack<>();
        Node prev = null;

        if (root == null) return;

        while (!st.isEmpty() || root != null) {
            if (root != null) {
                st.push(root);
                root = root.left;
            } else {
                root = st.peek();
                if (root.right == null || root.right == prev) {
                    System.out.print(" " + st.pop().data);
                    prev = root;
                    root = null;
                } else root = root.right;
            }

        }
    }
```

### Views of a BT

1. LEFT/RIGHT view of a BT:
- Initialize a list of type Node
- Start the recursion with root, list, and level=0
- if root == null return
- depending upon what side you have to view call the recursive method for that side
- if the size of the list == the level add the node to the list
- method(root->left,list,level+1)
- method(root->right,list,level+1)

```
private static void printRightView(Node root, ArrayList<Node> list, int level) {
    if (root == null) return;

    if (level == list.size())
        list.add(root);
    printRightView(root.right, list, level + 1);
    printRightView(root.left, list, level + 1);

}
```
- Finding Max depth of the Binary tree - max depth is also the height of the BT
- There are 2 ways of finding the max depth : 
- Using Level order Traversal 
- Using Recursion

``` 
   private static int maxDepthUsingRecursion(Node root){
        if(root == null) return 0;

        int lh = maxDepthUsingRecursion(root.left);
        int rh = maxDepthUsingRecursion(root.right);

        return 1+Math.max(lh,rh);
    }
```
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
### Bipartite Graph

1. Bipartite graph is the one where, if we color the graph and there are no such adjacent nodes with
2. same color then it is a bipartite graph.
3. Even length cycle and linear graphs are always bipartite

**Algorithm:**
1. Maintain a color array and fill it with -1 no color.
2. Traverse through all nodes if node is not colored pass it to BFS/DFS to color it

*Bipartite Using DFS*
```
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
```

*Bipartite Using BFS*
```
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
```

### Detect a cycle in a Directed graph using DFS

- In directed graph the regular dfs will not work as there might be a case where the node will be visited from another path.
and it will meet it and return true.
- So we maintain a pathVisited array where even if any node is previously visited and had not path visited then that route can be further traverse.
- PathVisited is also undone in each iteration -- i.e. it is backtracked to 0.

**STEPS**:
1. Maintain a pathVisited array of size V. 
2. For each vertex call dfs();
3. mark the node as visited and pathVisited
4. For each neighbor of node, n is not visited then dfs(n)
5. if n is visited and is also path visited means cycle is formed
6. return true
7. end for
8. return false
9. end


**Code**
```
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
```



### Topological sort using DFS
Topological Sort : linear ordering of vertices such that there is an edge between u & v u->v. 'v' appears before 'u'.
Only applicable for DAG.
DFS approach uses a stack DS

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

This algorithm uses in-degree for each vertex to form the topological sort sequence.
Queue DS is used in the process. This is a Breadth first search process. 

**STEPS:** 

1. In-degree of a graph:
```
        for (int i = 0; i < V; i++) {
            for (int n : adj.get(i)) {
                indegree[n]++;
            }
        }
```

2. add all nodes with in-degree 0 in the queue.
3. While queue is not empty,
   1. pop the queue = node
   2. store the node into the result array
   3. for each neighbour n of node relax the n i.e. reduce the in-degree of n by 1.
   4. If in-degree of n becomes 0 add it to queue.
4. return the result array.

**Code**

```
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
```
### Detect a Cycle in Directed Graph | Topological Sort | Kahn's Algorithm | BFS

1. Perform a normal topological sort on the DAG.
2. if at the end of the algorithm if number of elements in the result array < V. Cycle is present.
3. if result array.length == V no cycle. 








