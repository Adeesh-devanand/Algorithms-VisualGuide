package algorithmsvisualguide.model.graphing;

import algorithmsvisualguide.exceptions.InvalidVerticesException;
import algorithmsvisualguide.exceptions.VerticeNotSetException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;

public class BFS_bot implements Bot{
    ArrayList<ArrayList<Integer>> adjMatrix;
    LinkedList<Integer> queue;
    Set<Integer> visited;
    Integer start;
    Integer end;


    @Override
    public void load(ArrayList<ArrayList<Integer>> adj) {
        adjMatrix =  adj;
    }

    @Override
    public void setStart(int start) throws InvalidVerticesException {
        if (start >= adjMatrix.size() || start < 0) {
            throw new InvalidVerticesException();
        }
        this.start = start;
        queue.clear();
        queue.add(start);
    }

    @Override
    public void setEnd(int end) throws InvalidVerticesException {
        if (end >= adjMatrix.size() || end < 0) {
            throw new InvalidVerticesException();
        }
        this.end = end;
    }

    @Override
    public int getStart() {
        return start;
    }

    @Override
    public int getEnd() {
        return end;
    }

    @Override
    public Integer step() {
        int nextV = queue.pop();
        ArrayList<Integer> adjWeights = adjMatrix.get(nextV);

        for (int indexV = 0; indexV < adjWeights.size(); indexV++) {
            if (!visited.contains(indexV) && adjWeights.get(indexV) != 0) {
                queue.add(indexV);
            }
        }

        return nextV;
    }

    @Override
    public boolean solvable() throws VerticeNotSetException {
        if (start == null || end == null) {
            throw new VerticeNotSetException();
        }

        queue.clear();
        queue.add(start);

        while (!queue.isEmpty()) {
            int nextV = step();
            if (end.equals(nextV)) {
                return true;
            }
        }

        return false;
    }
}
