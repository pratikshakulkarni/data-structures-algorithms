package graphs;

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
    public static void main(String[] args) {
        ArrayList<GraphNode> nodes = new ArrayList<>();

        nodes.add(new GraphNode("A",0));
        nodes.add(new GraphNode("B",1));
        nodes.add(new GraphNode("C",2));
        nodes.add(new GraphNode("D",3));
        nodes.add(new GraphNode("E",4));

        Graph g = new Graph(nodes);
        g.addUndirectedEdge(0,1);
        g.addUndirectedEdge(0,2);
        g.addUndirectedEdge(0,3);
        g.addUndirectedEdge(1,4);
        g.addUndirectedEdge(2,3);
        g.addUndirectedEdge(3,4);

        System.out.printf(g.toString());
    }
}
