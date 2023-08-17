package algorithmsvisualguide.model.graphing;

import java.util.ArrayList;

public class Problem {
    ArrayList<ArrayList<Integer>> adjList;
    ArrayList<Integer> edgList;
    Bot alg;

    //Effects: Creates a problem with an Adjacency matrix loaded
    Problem(ArrayList<ArrayList<Integer>> adjList) {
        this.adjList = adjList;

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
    // returns -1 if there are no edges left
    int getEdge() {
        return alg.step().component1();
    }

    //Effects: checks if the problem is solvable with the given alg
    boolean solvable() {
        return alg.solvable();
    }
}
