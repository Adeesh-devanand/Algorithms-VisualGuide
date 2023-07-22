package model.Graphing.Algorithms;

import model.Graphing.EndException;
import model.Graphing.Graph.Problem;
import model.Graphing.Graph.Vertex;
import model.Graphing.Graph.WeightedVertex;
import model.Graphing.NoSolutionException;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijkstra implements Algo {
    Problem problem;
    PriorityQueue<WeightedVertex> priorityQueue = new PriorityQueue<>();
    Set<Vertex> visited = new HashSet<>();

    //Effects: loads the problem
    public void loadProblem(Problem p) {
        problem = p;
        priorityQueue.add((WeightedVertex) p.getStart());
    }
    @Override
    public Vertex step() throws NoSolutionException, EndException {

        WeightedVertex vertex =  priorityQueue.poll();

        while (visited.contains(vertex)) {
            vertex = priorityQueue.poll();
        }

        if (vertex == null) {
            throw new NoSolutionException();
        }

        if (vertex.equals(problem.getEnd())) {
            throw new EndException();
        }

        visited.add(vertex);
        int currWeight = vertex.getWeight();
        for (WeightedVertex weightedVertex : vertex.getAdj()) {
            weightedVertex.updateWeight(weightedVertex.getWeight() + currWeight);
            priorityQueue.add(weightedVertex);
        }
        return vertex;
    }
}

