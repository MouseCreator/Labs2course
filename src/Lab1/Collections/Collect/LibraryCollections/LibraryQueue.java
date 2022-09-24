package Lab1.Collections.Collect.LibraryCollections;

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
        q.add(v);
        return this;
    }

    @Override
    public T peekBack() {
        return q.peek();
    }

    @Override
    public T popBack()  {
        return q.remove();
    }
}
