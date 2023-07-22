package model.Graphing.Algorithms;

import model.Graphing.EndException;
import model.Graphing.Graph.Problem;
import model.Graphing.Graph.Vertex;
import model.Graphing.NoSolutionException;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class DepthFirstSearch implements Algo {

    Problem problem;
    LinkedList<Vertex> queue = new LinkedList<>();
    Set<Vertex> visited = new HashSet<>();

    //Effects: loads the problem
    @Override
    public void loadProblem(Problem p) {
        problem = p;
        queue.push(p.getStart());
    }
    @Override
    public Vertex step() throws NoSolutionException, EndException {
        if (queue.isEmpty()) {
            throw new NoSolutionException();
        }

        Vertex nextV = queue.pop();
        visited.add(nextV);
        for (Vertex v: nextV.getAdj()) {
            if (!visited.contains(v)) {
                queue.push(v);
            }
        }

        if (visited.contains(problem.getEnd())) {
            throw new EndException();
        }
        return nextV;
    }
}
