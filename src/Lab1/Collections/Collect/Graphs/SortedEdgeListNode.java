package Lab1.Collections.Collect.Graphs;

public class SortedEdgeListNode<T> {
    public T from;
    public T to;
    public int weight;
    public SortedEdgeListNode<T> next;

    public SortedEdgeListNode(T from, T to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
        this.next = null;
    }
}
