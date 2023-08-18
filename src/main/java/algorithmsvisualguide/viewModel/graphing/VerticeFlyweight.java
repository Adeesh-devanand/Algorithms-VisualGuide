package algorithmsvisualguide.viewModel.graphing;

import java.util.Map;

public class VerticeFlyweight {
    private Map<Integer, Vertice> verticeRegistry;

    public Vertice getVertice(int label) {
        if (!verticeRegistry.containsKey(label)) {
            verticeRegistry.put(label, new Vertice(label));
        }
        return verticeRegistry.get(label);
    }
}