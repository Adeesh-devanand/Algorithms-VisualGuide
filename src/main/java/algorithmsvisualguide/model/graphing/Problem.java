package algorithmsvisualguide.model.graphing;

import algorithmsvisualguide.exceptions.VerticeNotSetException;

import java.util.ArrayList;

public class Problem {
    ArrayList<ArrayList<Integer>> adjList;
    ArrayList<Integer> edgList;
    Bot bot;

    //Effects: creates a problem with an Adjacency matrix and algorithm
    Problem(ArrayList<ArrayList<Integer>> adjList, Algorithms ch) {
        this.adjList = adjList;
        setBot(ch);

        edgList = new ArrayList<>();
        adjList.forEach(edgList :: addAll);
    }

    //Modifies: this
    //Effects: chooses the algorithm to solve the problem
    private void setBot(Algorithms ch) {
        switch (ch) {
            case BFS:
                break;
            case DFS:
                break;
            case DIJKSTRA:
                break;
        }

        bot.load(adjList);
    }

    //Effects: returns the next edge that the algorithm visited,
    // returns null if there are no edges left
    Integer getEdge() throws VerticeNotSetException {
        return bot.step();
    }

    //Effects: checks if the problem is solvable with the given alg
    boolean solvable() throws VerticeNotSetException {
        return bot.solvable();
    }
}
