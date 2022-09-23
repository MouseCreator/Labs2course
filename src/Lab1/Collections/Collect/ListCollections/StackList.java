package Lab1.Collections.Collect.ListCollections;

import Lab1.Collections.Collect.Nodes.ListNode;
import Lab1.Collections.Collect.Stack;

public class StackList<T> implements Stack<T> {
    private final ImplicitList<T> list;
    private ListNode<T> begin;
    private int size;
    public StackList() {
        this.begin = null;
        this.size = 0;
        list = new ImplicitList<>();
    }

    @Override
    public int getSize() {
        return this.size;
    }
    public boolean isEmpty() {
        return this.size == 0;
    }

    public StackList<T> pushFront(T t) {
        this.begin = list.pushFront(begin, t);
        this.size++;
        return this;
    }

    public T peekFront()  {
        return list.peek(begin);
    }

    public T popFront()  {
        T result = list.peek(begin);
        this.begin = list.pop(begin);
        this.size--;
        return result;
    }

    @Override
    public String toString() {
        ListNode<T> node = this.begin;
        StringBuilder builder = new StringBuilder("[");
        while(node != null) {
            builder.append(" ");
            builder.append(node.getValue().toString());
            node = node.getNext();
        }
        builder.append(" ]");
        return builder.toString();
    }
    protected static StackList<Double> fromDouble(double[] source) {
        StackList<Double> result = new StackList<>();
        for (int i = source.length - 1; i >= 0; i--) {
            result.pushFront(source[i]);
        }
        return result;
    }

}
