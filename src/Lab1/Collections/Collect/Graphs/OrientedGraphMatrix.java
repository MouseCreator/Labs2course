package Lab1.Collections.Collect.Graphs;


import java.util.Arrays;
import java.util.HashMap;

public class OrientedGraphMatrix<T> {
    private final NodeIndexList nodeIndexList;
    private final int maxNodes;

    private final int NO_EDGE = 0;

    int[][] edges;

    HashMap<T, Integer> nodeIndex;

    public OrientedGraphMatrix(int maxNodes) {
        this.maxNodes = maxNodes;
        edges = new int[maxNodes][maxNodes];
        clearEdges();
        this.nodeIndexList = new NodeIndexList(maxNodes);
    }
    private void clearEdges() {
        for (int[] row : edges) {
            Arrays.fill(row, NO_EDGE);
        }
    }
    public void addNode(T value) {
        int index = nodeIndexList.getFirstFree();
        if (!indexOutOfBounds(index)) {
            nodeIndex.put(value, index);
            nodeIndexList.reserve(index);
        }
    }
    private boolean indexOutOfBounds(int index) {
        return index < 0 || index >= maxNodes;
    }
    public void removeNode(T value) {
        if (hasNode(value)) {
            int index = nodeIndex.get(value);
            nodeIndex.remove(value);
            nodeIndexList.free(index);
        }
    }
    private boolean hasNode(T key) {
         return nodeIndex.containsKey(key);
    }
    public void addEdge(T from, T to, int weight) {
        int indexFrom = getIndex(from);
        int indexTo = getIndex(to);
        setWeight(indexFrom, indexTo, weight);
    }
    private int getIndex(T value) {
        return hasNode(value) ? nodeIndex.get(value) : -1;
    }
    private void setWeight(int index1, int index2, int weight) {
        assert !indexOutOfBounds(index1) && !indexOutOfBounds(index2);
        edges[index1][index2] = weight;
    }
    private int getWeight(int index1, int index2) {
        assert !indexOutOfBounds(index1) && !indexOutOfBounds(index2);
        return edges[index1][index2];
    }

    private void removeEdge(T from, T to) {
        addEdge(from, to, NO_EDGE);
    }

    public void changeEdgeWeight(T from, T to, int weight) {
        addEdge(from, to, weight);
    }

    public int getWeight(T from, T to) {
        int index1 = getIndex(from);
        int index2 = getIndex(to);
        return getWeight(index1, index2);
    }

    public boolean hasEdge(T from, T to) {
        return getWeight(from, to) == NO_EDGE;
    }
}
