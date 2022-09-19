package Lab1.Collections.Collect.Graphs;


import java.util.Arrays;
import java.util.HashMap;

public class GraphMatrixOriented<T> extends Graph<T>{
    private final NodeIndexList nodeIndexList;
    private final int maxNodes;

    public int noEdge() { return NO_EDGE; }
    public int minEdge() { return MIN_EDGE; }

    int[][] edges;

    HashMap<T, Integer> nodeIndex;

    public GraphMatrixOriented(int maxNodes) {
        this.maxNodes = maxNodes;
        nodeIndex = new HashMap<>();
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
        if (indexInBounds(index)) {
            nodeIndex.put(value, index);
            nodeIndexList.reserve(index);
        }
    }
    private boolean indexInBounds(int index) {
        return index >= 0 && index < maxNodes;
    }

    public T[] getNodes() {
        return (T[])nodeIndex.keySet().toArray();
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
    public void addEdge(T from, T to) {
        addEdge(from, to, MIN_EDGE);
    }
    private int getIndex(T value) {
        return hasNode(value) ? nodeIndex.get(value) : -1;
    }
    private void setWeight(int index1, int index2, int weight) {
        assert indexInBounds(index1) && indexInBounds(index2);
        edges[index1][index2] = weight;
    }
    private int getWeight(int index1, int index2) {
        assert indexInBounds(index1) && indexInBounds(index2);
        return edges[index1][index2];
    }

    public void removeEdge(T from, T to) {
        addEdge(from, to, NO_EDGE);
    }

    public void changeEdgeWeight(T from, T to, int weight) {
        addEdge(from, to, weight);
    }


    /**
     *
     * @param from node, from which edge is to be built
     * @param to node, to which edge is to be built
     * @return the value of weight between {@param from} and {@param to} or NO_EDGE if they are not connected.
     */
    public int getWeight(T from, T to) {
        int index1 = getIndex(from);
        int index2 = getIndex(to);
        return getWeight(index1, index2);
    }

    public boolean hasEdge(T from, T to) {
        return getWeight(from, to) == NO_EDGE;
    }


    /**
     *
     * @param value: value of some node of the graph
     * @return true if there is a path from {@param value} to any other node
     */
    public boolean isConnectedWithAll(T value) {
        if (nodeIndex.containsKey(value))
            return isConnectedWithAll(nodeIndex.get(value));
        return false;
    }

    @Override
    public int getDistance(T from, T to) {
        return 0;
    }

    private boolean isConnectedWithAll(int index) {
        boolean[] visited = new boolean[maxNodes];
        DFS(visited, index);
        for (int i = 0; i < maxNodes; i++) {
            if (nodeIndexList.isReserved(i) && !visited[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @return true if graph is strong connected, false - if it is not
     */
    public boolean isStrongConnected() {
        for (T i : getNodes()) {
            if(!isConnectedWithAll(i)) {
                return false;
            }
        }
        return true;
    }

    private void DFS(boolean[] visited, int current) {
        visited[current] = true;
        for (int i = 0; i < maxNodes; i++) {
            if (edges[current][i] == NO_EDGE || visited[i])
                continue;
            DFS(visited, i);
        }
    }
}
