package algorithmsvisualguide.model.graphing;

import kotlin.Pair;

import java.util.ArrayList;

public class Problem {
    ArrayList<ArrayList<Integer>> adjList;
    ArrayList<Integer> edgList;
    Bot alg;

    //Effects: creates a problem with an Adjacency matrix and algorithm
    Problem(ArrayList<ArrayList<Integer>> adjList, Algorithms ch) {
        this.adjList = adjList;
        setAlg(ch);

        edgList = new ArrayList<>();
        adjList.forEach(edgList :: addAll);
    }

    //Modifies: this
    //Effects: chooses the algorithm to solve the problem
    public void setAlg(Algorithms ch) {
        switch (ch) {
            case BFS:
                break;
            case DFS:
                break;
            case DIJKSTRA:
                break;
        }

        alg.load(adjList);
    }

    //Effects: returns the next edge that the algorithm visited,
    // returns null if there are no edges left
    Integer getEdge() {
        return alg.step();
    }

    //Effects: checks if the problem is solvable with the given alg
    boolean solvable() {
        return alg.solvable();
    }
}
