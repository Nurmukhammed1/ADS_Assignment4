import java.util.*;

public class BreadthFirstSearch <V> extends Search<V>{
    public BreadthFirstSearch(WeightedGraph<V> graph, V source) {
        super(source);
        traverse(graph, source);
    }

    private void traverse(WeightedGraph<V> graph, V source) {
        Queue<V> queue = new LinkedList<>();
        queue.add(source);
        marked.add(source);
        while (!queue.isEmpty()) {
            V v = queue.poll();
            for (Vertex<V> vertex : graph.getVertex(v).getAdjacentVertices().keySet()) {
                if (!marked.contains(vertex.getData())) {
                    marked.add(vertex.getData());
                    edgeTo.put(vertex.getData(), v);
                    queue.add(vertex.getData());
                }
            }
        }
    }
}