import java.util.*;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjacentVertices = new HashMap<>();

    public Vertex(V data) {
        this.data = data;
    }

    public V getData() {
        return data;
    }

    public void addAdjacentVertices(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }

    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }
}
