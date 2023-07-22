package model.Graphing.Graph;

import java.util.HashMap;
import java.util.Map;

//Stores all the vertices in the entire graph
//Flyweight registry and factory
public class VertexRegistry {
    private final Map<Integer, Vertex> vList = new HashMap<>();

    public Vertex getVertex(int verticeID) {
        Vertex v;
        if (vList.containsKey(verticeID)) {
            v = vList.get(verticeID);
        } else {
            v = new Vertex(verticeID);
            vList.put(verticeID, v);
        }
        return v;
    }

    public WeightedVertex getVertex(int ... arr) {
        return getVertex(arr[0], arr[1]);
    }

    public WeightedVertex getVertex(int verticeID, int weight) {
        WeightedVertex v = new WeightedVertex(verticeID, weight);

        if (!vList.containsKey(verticeID)) {
            vList.put(verticeID, v);
        }

        return v;
    }
}
