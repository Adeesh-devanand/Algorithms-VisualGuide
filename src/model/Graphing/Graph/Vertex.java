package model.Graphing.Graph;

import java.util.*;

// Contains information about adjacent edges
public class Vertex {
    private final int vertexID;
    private final Set<WeightedVertex> vertices;

    public Vertex(int vertexID) {
        this.vertexID = vertexID;
        vertices = new HashSet<>();
    }

    public void addAdj(Set<WeightedVertex> adjEdges) {
        vertices.addAll(adjEdges);
    }

    public void addAdj(WeightedVertex vertex) {
        vertices.add(vertex);
    }

    public int getVertexID() {
        return vertexID;
    }

    public Set<WeightedVertex> getAdj() {
        return vertices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex)) return false;
        Vertex vertex = (Vertex) o;
        return getVertexID() == vertex.getVertexID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVertexID());
    }
}
