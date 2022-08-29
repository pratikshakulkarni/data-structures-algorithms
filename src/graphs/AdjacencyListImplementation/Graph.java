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
}
