import java.util.HashMap;
import java.util.Map;

public class WeightedGraph<V> {
    private Map<V, Vertex<V>> vertices = new HashMap<>();

    public void addVertex(V data) {
        vertices.put(data, new Vertex<>(data));
    }

    public void addEdge(V source, V dest) {
        addEdge(source, dest, 1.0);
    }

    public void addEdge(V source, V dest, double weight) {
        if (vertices.containsKey(source) == false) {
            addVertex(source);
        }

        if (vertices.containsKey(dest) == false) {
            addVertex(dest);
        }

        vertices.get(source).addAdjacentVertices(vertices.get(dest), weight);
        vertices.get(dest).addAdjacentVertices(vertices.get(source), weight);
    }

    public boolean hasVertex(V data) {
        return vertices.containsKey(data);
    }

    public Vertex<V> getVertex(V data) {
        return vertices.get(data);
    }

    public Iterable<V> getVertices() {
        return vertices.keySet();
    }

    public boolean hasEdge(V source, V dest) {
        if (hasVertex(source) == false) {
            return false;
        }

        return vertices.get(source).getAdjacentVertices().containsKey(vertices.get(dest));
    }

    public Double getWeight(V source, V dest) {
        if(hasEdge(source, dest) == false) {
            return Double.POSITIVE_INFINITY;
        }

        return vertices.get(source).getAdjacentVertices().get(vertices.get(dest));
    }

    public Iterable<V> getAdjacentVertices(V data) {
        return vertices.keySet();
    }
}
