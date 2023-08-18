package algorithmsvisualguide.viewModel.graphing;

import algorithmsvisualguide.exceptions.InvalidVerticesException;
import kotlin.Pair;

import java.util.ArrayList;
import java.util.Map;

public class Cluster {
    int edgIndex;
    Map<Integer, Edge> edgRegistry;

    // Effects: adds a vertice to the cluster
    void addVertice(Vertice v) {

    }

    // Effects: adds an edge with given weight to given vertices
    void addEdge(Pair<Vertice, Vertice> vertices, int weight) throws InvalidVerticesException {
        edgRegistry.put(++edgIndex, new Edge(vertices));
    }

    //Effects: returns the adjacency matrix of the cluster so far
    ArrayList<ArrayList<Integer>> getAdjMatrix() {
        return null;
    }

    //Effects: sets the start vertice
    void setStart(Vertice v) throws InvalidVerticesException {

    }

    //Effects: sets the end vertice
    void setEnd(Vertice v) throws InvalidVerticesException {

    }


    //called by model package

    //Effects: visits the edge and connected vertices
    void setVisited(int edge) {

    }
}
