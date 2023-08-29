package algorithmsvisualguide.model.graphing;
import org.jetbrains.annotations.NotNull;

public class WeightedEdge implements Comparable<WeightedEdge> {

    private final int weight;
    private final int from;
    private final int to;

    public WeightedEdge(int weight, int from, int to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }

    @Override
    public int compareTo(@NotNull WeightedEdge e) {
        return Integer.compare(weight, e.weight);
    }

    public int getTo() {
        return to;
    }

    public int getWeight() {
        return weight;
    }

    public int getFrom() {
        return from;
    }
}
