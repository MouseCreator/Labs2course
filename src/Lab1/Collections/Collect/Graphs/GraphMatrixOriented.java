package Lab1.Collections.Collect.Graphs;


import Lab1.Collections.Collect.ListCollections.QueueList;

import java.util.Arrays;
import java.util.HashMap;

public class GraphMatrixOriented<T> extends Graph<T>{
    private final NodeIndexList nodeIndexList;
    private final int maxNodes;

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

    public boolean empty() {
        return maxEstimatedSize() == 0;
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
        return
                (T[])nodeIndex.keySet().toArray();
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
    private boolean hasEdge(int index1, int index2) {
        return getWeight(index1, index2) != NO_EDGE;
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

    /**
     * @return if there is an edge between {@param from} and {@param to}
     */
    public boolean hasEdge(T from, T to) {
        return hasBoth(from, to) &&
                getWeight(from, to) != NO_EDGE;
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
    private boolean hasBoth(T from, T to) {
        return hasNode(from) && hasNode(to);
    }
    public int getDistance(T from, T to) {
        if (!hasBoth(from, to)) {
            return INFINITE_WEIGHT;
        }
        boolean[] visited = new boolean[maxEstimatedSize()];
        int[] minDistance = new int[maxEstimatedSize()];
        initMinDistance(minDistance, from);
        dijkstraAlgorithm(visited, minDistance);
        return minDistance[nodeIndex.get(to)];
    }

    private void initMinDistance(int[] minDistance, T from) {
        Arrays.fill(minDistance, INFINITE_WEIGHT);
        minDistance[nodeIndex.get(from)] = NO_EDGE;
    }

    private void dijkstraAlgorithm(boolean[] visited, int[] minDistance) {
        while (notAllVisited(visited)) {
            int i = getMinDistance(minDistance, visited);
            visited[i] = true;
            for (int j = 0; j < maxEstimatedSize(); j++) {
                if (hasEdge(i, j)) {
                    minDistance[j] = Math.min(minDistance[j], minDistance[i] + getWeight(i, j));
                }
            }
        }
    }
    private boolean notAllVisited(boolean[] visited) {
        for (boolean i : visited) {
            if (!i)
                return true;
        }
        return false;
    }

    private int getMinDistance(int[] minDistance, boolean[] visited) {
        int result = 0;
        int min = INFINITE_WEIGHT;
        for (int i = 0; i < minDistance.length; i++) {
            if (visited[i])
                continue;
            if (min > minDistance[i]) {
                min = minDistance[i];
                result = i;
            }
        }
        return result;

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Graph:\n");
        for (T from : nodeIndex.keySet()) {
           for (T to : nodeIndex.keySet()) {
               if (hasEdge(from, to)) {
                   builder.append(from)
                           .append("->")
                           .append(to)
                           .append("; weight: ")
                           .append(getWeight(from, to))
                           .append("\n");
               }
           }
        }
        return builder.toString();
    }

    /**
     *
     * @return Upper bound of reserved nodes; which is >= actual number of reserved nodes
     * and <= max possible number of nodes in the graph
     */
    private int maxEstimatedSize() {
        return this.nodeIndexList.maxIndex() + 1;
    }
    private boolean isConnectedWithAll(int index) {
        boolean[] visited = new boolean[maxEstimatedSize()];
        DFS(visited, index);
        for (int i = 0; i < visited.length; i++) {
            if (isUnvisited(i, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean isUnvisited(int index, boolean[] visited) {
        return nodeIndexList.isReserved(index) && !visited[index];
    }

    private void clearVisited(boolean[] visited) {
        Arrays.fill(visited, false);
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
        for (int i = 0; i < visited.length; i++) {
            if (edges[current][i] == NO_EDGE || visited[i])
                continue;
            DFS(visited, i);
        }
    }
    public boolean hasCycle() {
        boolean[] visited = new boolean[maxEstimatedSize()];
        for (int i = 0; i < visited.length; i++) {
            if (isUnvisited(i, visited)) {
                clearVisited(visited); //to avoid forks: (A->B), (C->B)
                if (BfsCycle(visited, i)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean BfsCycle(boolean[] visited, int current) {
        if (visited[current])
            return true;
        visited[current] = true;
        //used my own queue here
        QueueList<Integer> queue = new QueueList<>();
        for (int i = 0; i < visited.length; i++) {
            if (edges[current][i] == NO_EDGE)
                continue;
            queue.pushBack(i);
        }

        while(!queue.isEmpty()) {
           if (BfsCycle(visited, queue.popBack()))
               return true;
        }
        return false;
    }
}
