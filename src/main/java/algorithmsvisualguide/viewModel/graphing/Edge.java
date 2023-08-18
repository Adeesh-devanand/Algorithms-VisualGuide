package algorithmsvisualguide.viewModel.graphing;

import kotlin.Pair;

public class Edge {
    Vertice source;
    Vertice destination;

    Edge(Pair<Vertice, Vertice> verticePair) {
        this.source = verticePair.component1();
        this.destination = verticePair.component2();
    }

    void visit() {
        source.visit();
        destination.visit();
    }
}
