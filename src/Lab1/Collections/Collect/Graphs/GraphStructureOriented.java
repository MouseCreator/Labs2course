package Lab1.Collections.Collect.Graphs;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GraphStructureOriented<T> {
    HashMap<T, GraphNodeList<T>> nodes;

    private final int NO_EDGE = 0;
    private final int MIN_EDGE = 1;
    public GraphStructureOriented() {
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
    public void addEdge(T from, T to) {
        this.addEdge(from, to, MIN_EDGE);
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

    public T[] getNodes() {
        return (T[])nodes.keySet().toArray();
    }

    public boolean isConnectedWithAll(T node) {
        assert nodes.containsKey(node);
        if (nodes.isEmpty()) {
            return true;
        }
        ArrayList<T> visitedNodes = new ArrayList<>();
        DFS(visitedNodes, node);
        return visitedNodes.size() == nodes.size();
    }
    public boolean isStrongConnected() {
        for (T key :nodes.keySet())
        {
            if (!isConnectedWithAll(key))
                return false;
        }
        return true;
    }

    private void DFS(ArrayList<T> visited, T current) {
        visited.add(current);
        GraphNodeList<T> list = nodes.get(current);
        for (int i = 0; i < list.size(); i++) {
            T next = list.get(i);
            if (visited.contains(next))
                continue;
            DFS(visited, next);
        }
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
