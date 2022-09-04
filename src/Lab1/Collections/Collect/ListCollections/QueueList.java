package Lab1.Collections.Collect.ListCollections;

import Lab1.Collections.Collect.Nodes.ListNode;
import Lab1.Collections.Queue;

public class QueueList<T> implements Queue<T> {
    private ListNode<T> begin;
    private ListNode<T> end;
    private int size;

    private final ImplicitList<T> list;
    public QueueList() {
        this.size = 0;
        this.begin = null;
        list = new ImplicitList<>();
    }


    public void pushQ(T v) {
        this.end = list.push(end, v);
        if (this.begin == null) {
            this.begin = this.end;
        }
        this.size++;
    }

    public T peekQ() {
        return list.peek(begin);
    }

    public T popQ() {
        T result = list.peek(begin);
        this.begin = list.pop(begin);
        this.size--;
        if (this.begin == null) {
            this.end = null;
        }
        return result;
    }

    public void fillWithRandomValues(int num) {

    }
    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
