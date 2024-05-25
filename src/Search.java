import java.util.*;

public class Search<V> {
    V source;
    Set<V> marked;
    Map<V, V> edgeTo;

    public Search(V source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(V data) {
        return marked.contains(data);
    }

    public Iterable<V> getPathTo(V data) {
        if (hasPathTo(data) == false) {
            return null;
        }

        Stack<V> stack = new Stack<>();
        for (V x = data; x != null; x = edgeTo.get(x)) {
            stack.push(x);
        }

        return stack;
    }
}
