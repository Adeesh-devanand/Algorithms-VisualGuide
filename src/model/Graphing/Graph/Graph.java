package model.Graphing.Graph;

import model.Graphing.Algorithms.Algo;
import model.Graphing.Algorithms.BreadthFirstSearch;
import model.Graphing.Algorithms.DepthFirstSearch;
import model.Graphing.Algorithms.Dijkstra;
import model.Graphing.EndException;
import model.Graphing.NoSolutionException;

import java.util.LinkedList;

public class Graph {
    VertexRegistry vertexRegistry;
    LinkedList<Vertex> visited = new LinkedList<>();
    Algo algorithm;

    public Graph(VertexRegistry vr, Problem p, String alg) {
        vertexRegistry = vr;

        switch (alg) {
            case "BFS":
                algorithm = new BreadthFirstSearch();
                break;
            case "DFS":
                algorithm = new DepthFirstSearch();
                break;
            default:
                algorithm = new Dijkstra();
        }

        algorithm.loadProblem(p);
    }

    public void step() {
        try {
            Vertex nextV = algorithm.step();
            visited.add(nextV);

            System.out.println(nextV.getVertexID());

        } catch (NoSolutionException e) {
            throw new RuntimeException("There is no solution for the problem");
        } catch (EndException e) {
            throw new RuntimeException("End has been reached");
        }
    }

    public void solve() {
        while (true) {
            step();
        }
    }
}
