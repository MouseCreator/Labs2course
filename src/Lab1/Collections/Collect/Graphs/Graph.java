package Lab1.Collections.Collect.Graphs;

public abstract class Graph<T> {
    public final int MIN_EDGE = 1;
    public final int NO_EDGE = 0;

    public final int INFINITE_WEIGHT = Integer.MAX_VALUE / 2;

    public abstract void addNode(T node);
    public abstract void removeNode(T node);

    public abstract void addEdge(T from, T to, int weight);
    public abstract void addEdge(T from, T to);
    public abstract void changeEdgeWeight(T from, T to, int weight);
    public abstract void removeEdge(T from, T to);
    public abstract boolean isStrongConnected();
    public abstract boolean isConnectedWithAll(T value);

    public abstract int getDistance(T from, T to);
}
