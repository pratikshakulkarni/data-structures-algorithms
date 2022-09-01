package graphs.AdjacencyListImplementation;

import java.util.ArrayList;

public class AdjacencyListImplementation {

    public static void createUndirectedGraph(Graph g){
        g.addUndirectedEdges(0,1);
        g.addUndirectedEdges(0,2);
        g.addUndirectedEdges(1,3);
        g.addUndirectedEdges(1,6);
        g.addUndirectedEdges(2,3);
        g.addUndirectedEdges(2,4);
        g.addUndirectedEdges(3,5);
        g.addUndirectedEdges(4,5);
        g.addUndirectedEdges(5,6);
    }

    public static void createDirectedGraph(Graph g){
        g.addDirectedEdges(0,2);
        g.addDirectedEdges(2,4);
        g.addDirectedEdges(4,7);
        g.addDirectedEdges(4,5);
        g.addDirectedEdges(5,6);
        g.addDirectedEdges(1,2);
        g.addDirectedEdges(1,3);
        g.addDirectedEdges(3,5);
    }
    private static void makeNodeUnvisited(ArrayList<GraphNode> graphNodes) {
        graphNodes.forEach(node -> {node.isVisited=false;});
    }

    public static void main(String[] args) {
        ArrayList<GraphNode> graphNodes = new ArrayList<>();

        graphNodes.add(new GraphNode("A",0));
        graphNodes.add(new GraphNode("B",1));
        graphNodes.add(new GraphNode("C",2));
        graphNodes.add(new GraphNode("D",3));
        graphNodes.add(new GraphNode("E",4));
        graphNodes.add(new GraphNode("F",5));
        //graphNodes.add(new GraphNode("H",6));
        graphNodes.add(new GraphNode("G",6));

        Graph g = new Graph(graphNodes);
        createUndirectedGraph(g);
        //createDirectedGraph(g);
        System.out.println(g.toString());
        System.out.println("BFS : ");
        g.bfs();
        makeNodeUnvisited(graphNodes);
        System.out.println("\n DFS: ");
        g.dfs();
        //To run topological sort create directed graph first
//        makeNodeUnvisited(graphNodes);
//        System.out.println("\n Topological sort");
//        g.topologicalSort();
        makeNodeUnvisited(graphNodes);
        System.out.println("\n BFS for SSSPP");
        g.bfsForSsspp(graphNodes.get(0));

    }


}
