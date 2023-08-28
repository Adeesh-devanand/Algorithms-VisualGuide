package algorithmsvisualguide.model.graphing;

import algorithmsvisualguide.exceptions.InvalidVerticesException;
import algorithmsvisualguide.exceptions.VerticeNotSetException;

import java.util.ArrayList;

public interface Bot {
    //Modifies: this
    //Effects: loads the adjacency matrix into the bot
    void load(ArrayList<ArrayList<Integer>> adj);

    //Modifies: this
    //Effects: sets a starting vertice
    void setStart(int start) throws InvalidVerticesException;

    //Modifies: this
    //Effects: sets an end vertice
    void setEnd(int end) throws InvalidVerticesException;

    //Effects: gets start vertice
    int getStart();

    //Effects: gets end vertice
    int getEnd();

    //Modifies: this
    //Effects: returns the next edge(in serial format) visited,
    // null if there are no edges left
    Integer step() throws VerticeNotSetException;

    //Requires: adjList, start, end must be loaded
    //Modifies: this
    //Effects: possible to reach end from start?
    boolean solvable() throws VerticeNotSetException;
}
