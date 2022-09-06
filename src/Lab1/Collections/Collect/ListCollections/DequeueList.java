package Lab1.Collections.Collect.ListCollections;

import Lab1.Collections.Collect.Nodes.DoubleListNode;
import Lab1.Collections.Collect.Queue;
import Lab1.Collections.Collect.Stack;

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
    public DequeueList<T> PushBack(T v) {
        this.begin = list.pushFirst(begin, v);
        this.size++;
        return this;
    }

    @Override
    public T peekBack() {
        return list.peek(begin);
    }

    @Override
    public T popBack() {
        T result = list.peek(begin);
        this.begin = list.pop(begin);
        this.size--;
        return result;
    }

    @Override
    public DequeueList<T> pushFront(T v) {
        this.end = list.pushLast(end, v);
        this.size++;
        return this;
    }

    @Override
    public T peekFront() {
        return list.peek(end);
    }

    @Override
    public T popFront() {
        T result = list.peek(end);
        this.begin = list.pop(end);
        this.size--;
        return result;
    }
}
