package algorithmsvisualguide.model.graphing;

import algorithmsvisualguide.exceptions.InvalidVerticesException;
import algorithmsvisualguide.exceptions.NoEdgesToTraverse;
import algorithmsvisualguide.exceptions.VerticeNotSetException;

import java.util.ArrayList;

import static algorithmsvisualguide.model.graphing.Algorithms.BFS;

public class Problem {
    ArrayList<ArrayList<Integer>> adjMatrix;
    ArrayList<Integer> edgList;
    Bot bot;
    private Integer start;
    private Integer end;

    //Effects: creates a problem with an Adjacency matrix and algorithm
    public Problem(ArrayList<ArrayList<Integer>> adjMatrix) {
        this.adjMatrix = adjMatrix;
        setBot(BFS);

        edgList = new ArrayList<>();
        adjMatrix.forEach(edgList :: addAll);
    }

    //Modifies: this
    //Effects: chooses the algorithm to solve the problem
    public void setBot(Algorithms ch) {
        switch (ch) {
            case BFS:
                bot = new BFS_bot(adjMatrix);
                break;
            case DFS:
                bot = new DFS_bot(adjMatrix);
                break;
            case DIJKSTRA:
                bot = new DIJKSTRA_bot(adjMatrix);
                break;
        }
    }

    //Effects: returns the next edge that the algorithm visited,
    // returns null if there are no edges left
    public WeightedEdge getEdge() throws NoEdgesToTraverse {
        return bot.step();
    }

    //Effects: checks if the problem is solvable with the given alg
    public boolean solvable() throws VerticeNotSetException {
        bot.setStart(start);
        bot.setEnd(end);
        return bot.solvable();
    }


    public void setStart(Integer start) throws InvalidVerticesException {
        if (start >= adjMatrix.size() || start < 0) {
            throw new InvalidVerticesException();
        }
        this.start = start;
    }

    public void setEnd(Integer end) throws InvalidVerticesException {
        if (end >= adjMatrix.size() || end < 0) {
            throw new InvalidVerticesException();
        }
        this.end = end;
    }
}
