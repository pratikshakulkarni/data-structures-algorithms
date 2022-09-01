package graphs.AdjacencyMatrixImplementation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {

    ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
    int[][] adjacencyMatrix;

    public Graph(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
        adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
    }

    public void addUndirectedEdge(int i, int j) {
        adjacencyMatrix[i][j] = 1;
        adjacencyMatrix[j][i] = 1;
    }

    public void addDirectedEdges(int i, int j) {
        adjacencyMatrix[i][j] = 1;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("   ");
        for (int i = 0; i < nodeList.size(); i++)
            s.append(nodeList.get(i).name + " ");
        s.append("\n");
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + ": ");
            for (int j : adjacencyMatrix[i]) {
                s.append((j) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public ArrayList<GraphNode> getNeighbors(GraphNode node){
        ArrayList<GraphNode> neighbors = new ArrayList<>();
        int index = node.index;
        for(int i=0;i<adjacencyMatrix.length;i++){
            if(adjacencyMatrix[index][i]==1){
                neighbors.add(nodeList.get(i));
            }
        }
        return neighbors;
    }

    void bfsHelper(GraphNode node){
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            GraphNode currentNode = queue.remove(0);
            currentNode.isVisited=true;
            System.out.print(currentNode.name + " ");
            ArrayList<GraphNode> neighbours = getNeighbors(currentNode);
            for(GraphNode neighbour : neighbours){
                if(!neighbour.isVisited){
                    queue.add(neighbour);
                    neighbour.isVisited=true;
                }
            }
        }
    }
    void bfs(){
        for (GraphNode node : nodeList){
            if(!node.isVisited)
                bfsHelper(node);
        }
    }

    void dfsHelper(GraphNode node){
        Stack<GraphNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            GraphNode currentNode= stack.pop();
            System.out.print(currentNode.name + " ");
            currentNode.isVisited=true;
            ArrayList<GraphNode> neighbours = getNeighbors(currentNode);
            for(GraphNode neighbour : neighbours){
                if(!neighbour.isVisited){
                    stack.push(neighbour);
                    neighbour.isVisited=true;
                }
            }
        }
    }

    void dfs(){
        nodeList.forEach(node -> {
            if(!node.isVisited)
                dfsHelper(node);
        });
    }

    public void topologicalSort(){
        Stack<GraphNode> stack = new Stack<>();
        for(GraphNode node : nodeList) {
            if(!node.isVisited) {
                topologicalSortHelper(node,stack);
            }
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop().name+" ");
        }
    }

    private void topologicalSortHelper(GraphNode node, Stack<GraphNode> stack) {
        ArrayList<GraphNode> neighbours = getNeighbors(node);
        for(GraphNode neighbour : neighbours){
            topologicalSortHelper(node,stack);
        }
        node.isVisited=true;
        stack.push(node);
    }

    public static void pathFinder(GraphNode node){
        if(node.parent != null)
            pathFinder(node.parent);
        System.out.print(node.name +" ");
    }

    public void BFSForSSSPP(GraphNode node){
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            GraphNode currentNode = queue.remove(0);
            currentNode.isVisited=true;
            System.out.print("Path "+ currentNode.name + ": ");
            pathFinder(currentNode);
            System.out.println();
            ArrayList<GraphNode> neighbours = getNeighbors(currentNode);
            for(GraphNode neighbour : neighbours){
                if(!neighbour.isVisited){
                    queue.add(neighbour);
                    neighbour.isVisited=true;
                    neighbour.parent=currentNode;
                }
            }
        }
    }
}
