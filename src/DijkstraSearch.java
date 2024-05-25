import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private Map<V, Double> distanceMap = new HashMap<>();

    public DijkstraSearch(WeightedGraph<V> graph, V sourceVertex) {
        super(sourceVertex);
        for (V vertex : graph.getVertices()) {
            distanceMap.put(vertex, Double.POSITIVE_INFINITY);
        }
        distanceMap.put(sourceVertex, 0.0);
        traverse(graph);
    }

    private void traverse(WeightedGraph<V> graph) {
        while(true) {
            V closestVertex = null;
            double smallestDistance = Double.POSITIVE_INFINITY;

            for (V vertex : distanceMap.keySet()) {
                if (!marked.contains(vertex) && distanceMap.get(vertex) < smallestDistance) {
                    closestVertex = vertex;
                    smallestDistance = distanceMap.get(vertex);
                }
            }

            if (closestVertex == null)
                break;

            marked.add(closestVertex);

            for (V adjacentVertex : graph.getAdjacentVertices(closestVertex)) {
                if (!marked.contains(adjacentVertex)) {
                    double newDistance = distanceMap.get(closestVertex) + graph.getWeight(closestVertex, adjacentVertex);
                    if (newDistance < distanceMap.get(adjacentVertex)) {
                        distanceMap.put(adjacentVertex, newDistance);
                        edgeTo.put(adjacentVertex, closestVertex);
                    }
                }
            }
        }
    }
}
