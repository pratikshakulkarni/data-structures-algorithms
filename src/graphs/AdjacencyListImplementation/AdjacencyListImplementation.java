package graphs.AdjacencyListImplementation;

import java.util.ArrayList;

public class AdjacencyListImplementation {
    public static void main(String[] args) {
        ArrayList<GraphNode> graphNodes = new ArrayList<>();

        graphNodes.add(new GraphNode("A",0));
        graphNodes.add(new GraphNode("B",1));
        graphNodes.add(new GraphNode("C",2));
        graphNodes.add(new GraphNode("D",3));
        graphNodes.add(new GraphNode("E",4));

        Graph g = new Graph(graphNodes);

        g.addUndirectedEdges(0,1);
        g.addUndirectedEdges(0,2);
        g.addUndirectedEdges(0,3);
        g.addUndirectedEdges(1,4);
        g.addUndirectedEdges(2,3);
        g.addUndirectedEdges(3,4);

        System.out.println(g.toString());

        System.out.println("BFS : ");
        g.bfs();

        graphNodes.forEach(node -> {
            node.isVisited=false;
        });

        System.out.println("\n DFS: ");
        g.dfs();
    }
}
