package model.Graphing.Algorithms;

import model.Graphing.EndException;
import model.Graphing.Graph.Problem;
import model.Graphing.Graph.Vertex;
import model.Graphing.NoSolutionException;

public interface Algo {

    //Effects: loads the problem
    public void loadProblem(Problem p);

    //Requires: the problem should be loaded first
    //Effects: chooses the next step in the problem
    public Vertex step() throws NoSolutionException, EndException;

}
