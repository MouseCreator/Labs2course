package Lab1.Collections.Collect.Graphs;

import Lab1.Collections.Collect.Nodes.GraphNode;

public class SortedEdgeList<T> {
    SortedEdgeListNode<T> begin = null;

    public boolean empty() {
        return begin == null;
    }
    public void add(T from, GraphNodeList<T> list) {
        while (!list.empty()) {
            GraphNode<T> node = list.popLast();
            add(from, node.getValue(), node.getWeight());
        }
    }
    public void add(T from, T to, int weight) {
        SortedEdgeListNode<T> toAdd = new SortedEdgeListNode<>(from, to, weight);
        if (empty()) {
            begin = toAdd;
        }
        else {
            insertNode(toAdd);
        }
    }
    public void insertNode(SortedEdgeListNode<T> node) {
        assert begin != null;
        if (node.weight < begin.weight) {
            node.next = begin;
            begin = node;
        }
        else {
            SortedEdgeListNode<T> current = begin;
            while (current.next != null && node.weight > current.weight) {
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
        }
    }
    public SortedEdgeListNode<T> pop() {
        SortedEdgeListNode<T> result = begin;
        begin = begin.next;
        return result;
    }
}
