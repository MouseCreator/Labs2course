package Lab1.Collections.Collect.ListCollections;

import Lab1.Collections.Collect.Nodes.ListNode;
import Lab1.Collections.Collect.Queue;

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


    public QueueList<T> pushBack(T v) {
        this.end = list.pushBack(end, v);
        if (this.begin == null) {
            this.begin = this.end;
        }
        this.size++;
        return this;
    }

    public T peekBack() {
        return list.peek(begin);
    }

    public T popBack() {
        T result = list.peek(begin);
        this.begin = list.pop(begin);
        this.size--;
        if (this.begin == null) {
            this.end = null;
        }
        return result;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public String toString() {
        ListNode<T> current = begin;
        StringBuilder builder = new StringBuilder("[");
        while (current != null && current != end) {
            builder.append(current.getValue().toString()).append(", ");
            current = current.getNext();
        }
        if (current != null) {
            builder.append(current.getValue());
        }
        builder.append("]");
        return builder.toString();
    }
}
