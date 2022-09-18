package Lab1.Collections.Collect.Nodes;

public class GraphNode<T> extends Node<T> {
    public GraphNode(T v) {
        super(v);
        this.weight = 1;
    }
    public GraphNode(T v, int weight) {
        super(v);
        this.weight = weight;
    }
    private int weight;

    public GraphNode(T v, int weight, GraphNode<T> next) {
        super(v);
        this.weight = weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getWeight() {
        return weight;
    }

}
