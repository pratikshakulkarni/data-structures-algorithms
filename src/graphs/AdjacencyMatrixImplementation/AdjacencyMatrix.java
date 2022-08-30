package graphs.AdjacencyMatrixImplementation;

import java.util.ArrayList;

/***
 * A-B 0-1 1-0
 * A-C 0-2 2-0
 * A-D 0-3 3-0
 * B-E 1-4 4-1
 * C-D 2-3 3-2
 * D-E 3-4 4-3
 */

public class AdjacencyMatrix {

    private static void makeNodeVisitedFalse(ArrayList<GraphNode> nodes) {
        nodes.forEach(node -> node.isVisited=false);
    }

    private static void createUndirectedGraph(Graph g){
        g.addUndirectedEdge(0,1);
        g.addUndirectedEdge(0,2);
        g.addUndirectedEdge(0,3);
        g.addUndirectedEdge(1,4);
        g.addUndirectedEdge(2,3);
        g.addUndirectedEdge(3,4);
    }

    private static void createDirectedGraph(Graph g){
        g.addDirectedEdges(0,2);
        g.addDirectedEdges(2,4);
        g.addDirectedEdges(4,7);
        g.addDirectedEdges(4,5);
        g.addDirectedEdges(5,6);
        g.addDirectedEdges(1,2);
        g.addDirectedEdges(1,3);
        g.addDirectedEdges(3,5);
    }
    public static void main(String[] args) {
        ArrayList<GraphNode> nodes = new ArrayList<>();

        nodes.add(new GraphNode("A",0));
        nodes.add(new GraphNode("B",1));
        nodes.add(new GraphNode("C",2));
        nodes.add(new GraphNode("D",3));
        nodes.add(new GraphNode("E",4));

        Graph g = new Graph(nodes);
        //createUndirectedGraph(g);
        createDirectedGraph(g);

        System.out.printf(g.toString());

        System.out.println("BFS ");
        g.bfs();

        makeNodeVisitedFalse(nodes);

        System.out.println("\n DFS: ");
        g.dfs();

        makeNodeVisitedFalse(nodes);
        System.out.println("\n Topological sort ");
        g.topologicalSort();
    }

}
