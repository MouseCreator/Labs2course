package Lab1.Collections.Collect.Graphs;

import Lab1.Collections.Collect.Nodes.GraphNode;
import Lab1.Collections.Collect.Nodes.ListNode;

import java.util.LinkedList;

public class GraphNodeList<T> {
    private LinkedList<GraphNode<T>> nodes;

    public void add(T value, int weight) {
        nodes.add(new GraphNode<T>(value, weight));
    }
    public void remove(T value) {
        nodes.remove(find(value));
    }
    public void changeWeight(T value, int weight) {
        find(value).setWeight(weight);
    }
    private GraphNode<T> find(T value) {
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).getValue().equals(value)) {
                return nodes.get(i);
            }
        }

        return null;
    }
    public boolean has(T value) {
        return find(value) != null;
    }
}
