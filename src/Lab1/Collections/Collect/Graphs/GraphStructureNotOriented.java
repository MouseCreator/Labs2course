package Lab1.Collections.Collect.Graphs;

public class GraphStructureNotOriented<T> extends GraphStructureOriented<T> {
    public GraphStructureNotOriented() {
        super();
    }

    @Override
    public void addEdge(T from, T to, int weight) {
        super.addEdge(from, to, weight);
        super.addEdge(to, from, weight);
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
