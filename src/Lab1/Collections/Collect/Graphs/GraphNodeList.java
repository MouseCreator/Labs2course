package Lab1.Collections.Collect.Graphs;

import Lab1.Collections.Collect.Nodes.GraphNode;

import java.util.LinkedList;

public class GraphNodeList<T> {
    private LinkedList<GraphNode<T>> edges;

    public void add(T value, int weight) {
        edges.add(new GraphNode<T>(value, weight));
    }
    public void remove(T value) {
        edges.remove(find(value));
    }
    public void changeWeight(T value, int weight) {
        find(value).setWeight(weight);
    }
    public GraphNode<T> find(T value) {
        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i).getValue().equals(value)) {
                return edges.get(i);
            }
        }

        return null;
    }
    public boolean has(T value) {
        return find(value) != null;
    }
    public String iterate(T from) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < edges.size(); i++) {
            GraphNode<T> node = edges.get(i);
            builder.append(from.toString()).
                    append("->").
                    append(node.getValue().toString()).
                    append("; weight: ").
                    append(node.getWeight());
        }
        return builder.toString();
    }
}
