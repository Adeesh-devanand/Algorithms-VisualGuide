package model.Graphing.Graph;

public class WeightedVertex extends Vertex implements Comparable<WeightedVertex>  {
    Vertex vertex;
    int weight;

    public WeightedVertex(int vertexID, int weight) {
        super(vertexID);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void updateWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(WeightedVertex v) {
        return Integer.compare(weight, v.getWeight());
    }
}
