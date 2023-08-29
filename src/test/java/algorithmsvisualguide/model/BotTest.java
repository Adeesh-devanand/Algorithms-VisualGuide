package algorithmsvisualguide.model;

import algorithmsvisualguide.exceptions.InvalidVerticesException;
import algorithmsvisualguide.exceptions.VerticeNotSetException;
import algorithmsvisualguide.model.graphing.Algorithms;
import algorithmsvisualguide.model.graphing.Problem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class BotTest {
    ArrayList<ArrayList<Integer>> adjMatrix;

    Problem problem0;
    Problem problem1;
    Problem problem2;

    @BeforeEach
    public void initialize() {
        adjMatrix = new ArrayList<>();
        adjMatrix.add(new ArrayList<>(Arrays.asList(-1, -1, -1, -1)));
        adjMatrix.add(new ArrayList<>(Arrays.asList(-1, -1, -1, 1)));
        adjMatrix.add(new ArrayList<>(Arrays.asList(-1, -1, -1, -1)));
        adjMatrix.add(new ArrayList<>(Arrays.asList(-1, -1, -1, -1)));
        problem0 = new Problem(adjMatrix);
        try {
            problem0.setStart(0);
            problem0.setEnd(3);
        } catch (InvalidVerticesException e) {
            Assertions.fail();
        }


        adjMatrix = new ArrayList<>();
        adjMatrix.add(new ArrayList<>(Arrays.asList(-1, 2, 4, -1)));
        adjMatrix.add(new ArrayList<>(Arrays.asList(-1, -1, -1, 1)));
        adjMatrix.add(new ArrayList<>(Arrays.asList(-1, -1, -1, -1)));
        adjMatrix.add(new ArrayList<>(Arrays.asList(-1, -1, -1, -1)));
        problem1 = new Problem(adjMatrix);
        try {
            problem1.setStart(0);
            problem1.setEnd(3);
        } catch (InvalidVerticesException e) {
            Assertions.fail();
        }
    }

    @Test
    public void Dijkstra() {
        checkSolvable(Algorithms.DIJKSTRA, problem0, false);
        checkSolvable(Algorithms.DIJKSTRA, problem1, true);
    }
    @Test
    public void DFS() {
        checkSolvable(Algorithms.DFS, problem0, false);
        checkSolvable(Algorithms.DFS, problem1, true);
    }


    @Test
    public void BFS() {
        checkSolvable(Algorithms.BFS, problem0, false);
        checkSolvable(Algorithms.BFS, problem1, true);
    }

    private void checkSolvable(Algorithms alg, Problem problem, boolean solvable) {
        try {
            problem.setBot(alg);
            boolean botAns = problem.solvable();
            Assertions.assertEquals(botAns, solvable);
        } catch (VerticeNotSetException e) {
                Assertions.fail();
        }
    }
}
