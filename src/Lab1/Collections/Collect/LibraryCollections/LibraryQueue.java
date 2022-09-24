package Lab1.Collections.Collect.LibraryCollections;

import Lab1.Collections.Collect.EmptyException;
import Lab1.Collections.Collect.OversizeException;

import java.util.concurrent.ArrayBlockingQueue;

public class LibraryQueue<T> implements Lab1.Collections.Collect.Queue<T> {

    private final ArrayBlockingQueue<T> q;

    public LibraryQueue(int capacity) {
        q = new ArrayBlockingQueue<>(capacity);
    }

    @Override
    public int getSize() {
        return q.size();
    }

    @Override
    public boolean isEmpty() {
        return q.isEmpty();
    }

    @Override
    public Lab1.Collections.Collect.Queue<T> pushBack(T v) {
        try {
            q.add(v);
        } catch (IllegalStateException e) {
            throw new OversizeException("Queue is full");
        }
        return this;
    }

    @Override
    public T peekBack() {
        if (q.isEmpty()) {
            throw new EmptyException();
        }
        return q.peek();
    }

    @Override
    public T popBack()  {
        if (q.isEmpty()) {
            throw new EmptyException();
        }
        return q.remove();
    }
}
