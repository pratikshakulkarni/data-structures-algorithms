package graphs.AdjacencyListImplementation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
    ArrayList<GraphNode> nodes = new ArrayList<>();

    public Graph(ArrayList<GraphNode> nodes){
        this.nodes=nodes;
    }

    public void addUndirectedEdges(int i, int j){
        GraphNode first = nodes.get(i);
        GraphNode second = nodes.get(j);
        first.neighbours.add(second);
        second.neighbours.add(first);
    }

    public void addDirectedEdges(int i, int j){
        GraphNode first = nodes.get(i);
        GraphNode second = nodes.get(j);
        first.neighbours.add(second);
    }

    public String toString(){
        StringBuilder s = new StringBuilder();

        for(int i=0;i<nodes.size();i++){
            s.append(nodes.get(i).name + ": ");
            for (int j=0;j<nodes.get(i).neighbours.size();j++){
                if(j == nodes.get(i).neighbours.size()-1 ){
                    s.append(nodes.get(i).neighbours.get(j).name);
                }else{
                    s.append(nodes.get(i).neighbours.get(j).name + " ->");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }

    public void bfsHelper(GraphNode node){
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            GraphNode currentNode = queue.remove(0);
            System.out.print(currentNode.name + " ");
            currentNode.isVisited=true;
            for(GraphNode neighbour : currentNode.neighbours){
                if(!neighbour.isVisited) {
                    queue.add(neighbour);
                    neighbour.isVisited=true;
                }
            }
        }
    }

    public void bfs(){
        for(GraphNode node : nodes){
            if(!node.isVisited)
                bfsHelper(node);
        }
    }

    public void dfsHelper(GraphNode node){
        Stack<GraphNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            GraphNode currentNode = stack.pop();
            currentNode.isVisited=true;
            System.out.print(currentNode.name+" ");
            for(GraphNode neighbour : currentNode.neighbours){
                if(!neighbour.isVisited){
                    stack.push(neighbour);
                    neighbour.isVisited=true;
                }
            }
        }
    }

    public void dfs(){
        for(GraphNode node : nodes){
            if(!node.isVisited)
                dfsHelper(node);
        }
    }

     void topologicalSortHelper(GraphNode node, Stack<GraphNode> stack) {
        for(GraphNode neighbour : node.neighbours){
            if(!neighbour.isVisited){
                topologicalSortHelper(neighbour,stack);
            }
        }
        node.isVisited = true;
        stack.push(node);
    }

    public void topologicalSort(){
        Stack<GraphNode> stack = new Stack<>();
        for(GraphNode node :nodes){
            if(!node.isVisited){
                topologicalSortHelper(node,stack);
            }
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop().name+" ");
        }
    }

    public static void pathFinder(GraphNode node){
        if(node.parent != null)
            pathFinder(node.parent);
        System.out.print(node.name + " ");
    }

    public void bfsForSsspp(GraphNode node){
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            GraphNode currentNode = queue.remove(0);
            currentNode.isVisited=true;
            System.out.print("Path " + currentNode.name + ": ");
            pathFinder(currentNode);
            System.out.println();
            for(GraphNode neighbour : currentNode.neighbours){
                if(!neighbour.isVisited){
                    queue.add(neighbour);
                    neighbour.isVisited=true;
                    neighbour.parent=currentNode;
                }
            }
        }
    }


}
