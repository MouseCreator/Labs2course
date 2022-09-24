package Lab1.Collections.Collect.ListCollections;

import Lab1.Collections.Collect.EmptyException;
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

    /**
     *
     * @return number of nodes in the dequeue
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     *
     * @return if there is no nodes in the dequeue
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     *
     * @param v is an element to add
     * @return itself
     */
    @Override
    public DequeueList<T> pushFront(T v) {
        this.begin = list.pushFirst(begin, v);
        this.size++;
        if (this.end == null) {
            this.end = this.begin;
        }
        return this;
    }

    /**
     *
     * @return the first element in the dequeue
     * @throws EmptyException if dequeue is empty
     */
    @Override
    public T peekFront() throws EmptyException {
        return list.peek(begin);
    }

    /**
     * Removes the first element in the dequeue
     * @return the removed element
     * @throws EmptyException if dequeue is empty
     */
    @Override
    public T popFront() throws EmptyException {
        T result = list.peek(begin);
        this.begin = list.pop(begin);
        if (begin == null) {
            end = null;
        }
        this.size--;
        return result;
    }

    /**
     * Adds an element to the back of the dequeue
     * @param v the element to add to the front of the queue
     * @return itself
     */
    @Override
    public DequeueList<T> pushBack(T v) {
        this.end = list.pushLast(end, v);
        this.size++;
        if (this.begin == null) {
            this.begin = this.end;
        }
        return this;
    }

    /**
     *
     * @return the back element of the dequeue
     * @throws EmptyException if dequeue is empty
     */
    @Override
    public T peekBack() throws EmptyException {
        return list.peek(end);
    }

    /**
     * Removes the element in the back of the dequeue
     * @return the removed element
     * @throws EmptyException if dequeue is empty
     */
    @Override
    public T popBack() throws EmptyException {
        T result = list.peek(end);
        this.end = list.pop(end);
        if (end == null) {
            begin = null;
        }
        this.size--;
        return result;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        DoubleListNode<T> current = begin;

        while (current != null && current != end) {
            builder.append(current.getValue()).append(", ");
            current = current.getNext();
        }
        if (current != null) {
            builder.append(current.getValue());
        }
        builder.append("]");
        return builder.toString();
    }
}
