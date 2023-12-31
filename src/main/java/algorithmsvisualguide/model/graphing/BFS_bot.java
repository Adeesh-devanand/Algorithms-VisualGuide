package algorithmsvisualguide.model.graphing;

import algorithmsvisualguide.exceptions.NoEdgesToTraverse;
import algorithmsvisualguide.exceptions.VerticeNotSetException;

import java.util.*;

public class BFS_bot implements Bot{
    ArrayList<ArrayList<Integer>> adjMatrix;
    LinkedList<WeightedEdge> queue;
    Set<Integer> visited;
    Integer start;
    Integer end;

    public BFS_bot(ArrayList<ArrayList<Integer>> adjMatrix) {
        this.adjMatrix = adjMatrix;
        this.queue = new LinkedList<>();
        this.visited = new HashSet<>();
    }

    @Override
    public void setStart(int start){
        this.start = start;
        queue.clear();
        queue.add(new WeightedEdge(0, start, start));
    }

    @Override
    public void setEnd(int end) {
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
    public WeightedEdge step() throws NoEdgesToTraverse {
        WeightedEdge currEdge;

        try {
            currEdge = queue.pop();
        } catch (NoSuchElementException e) {
            throw new NoEdgesToTraverse();
        }

        int currV = currEdge.getTo();
        int currW = currEdge.getWeight();

        ArrayList<Integer> adjWeights = adjMatrix.get(currV);

        for (int nextV = 0; nextV < adjWeights.size(); nextV++) {
            int nextW = adjWeights.get(nextV);
            if (!visited.contains(nextV) && nextW != -1) {
                visited.add(nextV);
                queue.add(new WeightedEdge(currW+ nextW, currV, nextV));
            }
        }

        return currEdge;
    }

    @Override
    public boolean solvable() throws VerticeNotSetException {
        if (start == null || end == null) {
            throw new VerticeNotSetException();
        }

        queue.clear();
        queue.add(new WeightedEdge(0, start, start));

        while (true) {
            WeightedEdge currE;
            try {
                currE = step();
            } catch (NoEdgesToTraverse e) {
                return false;
            }
            if (end.equals(currE.getTo())) {
                return true;
            }
        }
    }
}