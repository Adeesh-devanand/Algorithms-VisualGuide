package algorithmsvisualguide.model.graphing;

import algorithmsvisualguide.exceptions.InvalidVerticesException;
import algorithmsvisualguide.exceptions.NoEdgesToTraverse;
import algorithmsvisualguide.exceptions.VerticeNotSetException;

import java.util.ArrayList;

public interface Bot {

    //Modifies: this
    //Effects: sets a starting vertice
    void setStart(int start);

    //Modifies: this
    //Effects: sets an end vertice
    void setEnd(int end);

    //Effects: gets start vertice
    int getStart();

    //Effects: gets end vertice
    int getEnd();

    //Modifies: this
    //Effects: returns the next edge visited in the iteration,
    WeightedEdge step() throws NoEdgesToTraverse;

    //Requires: adjList, start, end must be loaded
    //Modifies: this
    //Effects: possible to reach end from start?
    boolean solvable() throws VerticeNotSetException;
}
