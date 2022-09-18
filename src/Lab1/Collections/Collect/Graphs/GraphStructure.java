package Lab1.Collections.Collect.Graphs;


import java.util.HashMap;

public class GraphStructure<T> {
    HashMap<T, GraphNodeList<T>> nodes;

    private final int NO_EDGE = 0;
    public GraphStructure() {
        this.nodes = new HashMap<>();
    }

    public void addEdge(T from, T to, int weight) {
        if (!nodes.containsKey(from)) {
            createNewNodeList(from, to, weight);
        }
        else {
            assert !hasPair(from, to);
            addToExistingList(from, to, weight);
        }
    }

    private void createNewNodeList(T from, T to, int weight) {
        GraphNodeList<T> list = new GraphNodeList<>();
        list.add(to, weight);
        nodes.put(from, list);
    }
    private void addToExistingList(T from, T to, int weight) {
        nodes.get(from).add(to, weight);
    }

    public void removeEdge(T from, T to) {
        if(hasPair(from, to)) {
            removePair(from, to);
        }
    }
    private boolean hasPair(T from, T to) {
        return nodes.containsKey(from) && nodes.get(from).has(to);
    }
    private void removePair(T from, T to) {
        nodes.get(from).remove(to);
    }

    public void changeEdgeWeight(T from, T to, int weight) {
        if(hasPair(from, to)) {
            changeWeightPair(from, to, weight);
        }
    }
    private void changeWeightPair(T from, T to, int weight) {
        nodes.get(from).changeWeight(to, weight);
    }

    public void addNode(T value) {
        nodes.put(value, new GraphNodeList<>());
    }
    public void removeNode(T value) {
        nodes.remove(value);
        removeAllIncidentalEdges(value);
    }

    private void removeAllIncidentalEdges(T node) {
        for (T key : nodes.keySet()) {
            nodes.get(key).remove(node);
        }
    }

    public int getWeight(T from, T to) {
        if (hasBoth(from, to)) {
            return nodes.get(from).find(to).getWeight();
        }
        return NO_EDGE;
    }
    public boolean hasEdge(T from, T to) {
        return getWeight(from, to) == NO_EDGE;
    }
    public boolean hasBoth(T from, T to) {
        return nodes.containsKey(from) && nodes.containsKey(to);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Graph:\n");
        for (T key : nodes.keySet()) {
            builder.append(nodes.get(key).iterate(key));
        }
        return builder.toString();
    }

}
