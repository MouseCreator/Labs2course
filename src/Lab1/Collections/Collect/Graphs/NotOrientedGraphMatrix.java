package Lab1.Collections.Collect.Graphs;

public class NotOrientedGraphMatrix<T> extends OrientedGraphMatrix<T>{
    public NotOrientedGraphMatrix(int maxNodes) {
        super(maxNodes);
    }
    @Override
    public void addEdge(T from, T to, int weight) {
        super.addEdge(from, to, weight);
        super.addEdge(from, to, weight);
    }
    @Override
    public void removeEdge(T from, T to) {
        super.removeEdge(from, to);
        super.removeEdge(to, from);
    }
    @Override
    public void changeEdgeWeight(T from, T to, int weight) {
        super.changeEdgeWeight(from, to, weight);
        super.changeEdgeWeight(to, from, weight);
    }

}
