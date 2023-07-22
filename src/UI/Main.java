package UI;

import model.Graphing.Graph.Graph;
import model.Graphing.Graph.Problem;
import model.Graphing.Graph.Vertex;
import model.Graphing.Graph.VertexRegistry;

public class Main {
    static VertexRegistry vr = new VertexRegistry();
    static Problem p = new Problem();

    public static void main(String args[]) {
        vr.getVertex(0, 0);
        addVertices(0, new int[][]{{1, 10}, {2, 3}, {3, 20}});
        addVertices(1, new int[][]{{3, 5}});
        addVertices(2, new int[][]{{1, 2}, {4, 15}});
        addVertices(3, new int[][]{{4, 11}});

        p.setStart(vr.getVertex(0));
        p.setEnd(vr.getVertex(3));

        Graph g = new Graph(vr, p, "Dijkstra");

        g.solve();

    }

    private static void addVertices(int verticeID, int[][] weightedAdj) {
        Vertex v = vr.getVertex(verticeID);
        for(int[] weightedVertex : weightedAdj) {
            v.addAdj(vr.getVertex(weightedVertex));
        }
    }


}
