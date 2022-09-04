package Lab1.Collections.ListCollections;

import Lab1.Collections.Nodes.DoubleListNode;
import Lab1.Collections.Queue;
import Lab1.Collections.Stack;

public class DequeueList<T> implements Stack<T>, Queue<T> {

    private int size;
    private DoubleListNode<T> begin;
    private DoubleListNode<T> end;
    ImplicitDoubleList<T> list;
    public DequeueList() {
        list = new ImplicitDoubleList<>();
        size = 0;
        begin = null;
        end = null;
    }
    @Override
    public void fillWithRandomValues(int num) {

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void pushQ(T v) {
        this.begin = list.pushFirst(begin, v);
        this.size++;
    }

    @Override
    public T peekQ() {
        return list.peek(begin);
    }

    @Override
    public T popQ() {
        T result = list.peek(begin);
        this.begin = list.pop(begin);
        this.size--;
        return result;
    }

    @Override
    public void pushS(T v) {
        this.end = list.pushLast(end, v);
        this.size++;
    }

    @Override
    public T peekS() {
        return list.peek(end);
    }

    @Override
    public T popS() {
        T result = list.peek(end);
        this.begin = list.pop(end);
        this.size--;
        return result;
    }
}
