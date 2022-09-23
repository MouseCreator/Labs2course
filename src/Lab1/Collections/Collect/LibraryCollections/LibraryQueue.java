package Lab1.Collections.Collect.LibraryCollections;

import java.util.Queue;

public class LibraryQueue<T> implements Lab1.Collections.Collect.Queue<T> {

    private Queue q;

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
        return (T) q.peek();
    }

    @Override
    public T popBack()  {
        return (T) q.remove();
    }
}
