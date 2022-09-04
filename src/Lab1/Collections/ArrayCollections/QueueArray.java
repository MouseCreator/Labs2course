package Lab1.Collections.ArrayCollections;

import Lab1.Collections.Queue;

import java.util.Arrays;

public class QueueArray<T> implements Queue<T>, ArrayCollection{
    int firstInQueue;
    int lastInQueue;

    public QueueArray() {
        firstInQueue = -1;
        lastInQueue = -1;
        limit = 1024;
        initArray();
    }
    public QueueArray(int limit) {
        firstInQueue = -1;
        lastInQueue = -1;
        this.limit = limit;
        initArray();
    }
    private void initArray() {
        this.array = (T[])new Object[limit];
    }

    private T[] array;
    private int limit;
    private boolean indexOutOfBounds(int index) {
        return index >= limit;
    }
    private void checkFirst() {
        if (indexOutOfBounds(firstInQueue)) {
            replaceFirst();
        }
    }
    private void checkLast() {
        if (indexOutOfBounds(lastInQueue)) {
            replaceLast();
        }
    }
    private void replaceFirst() {
        firstInQueue = 0;
    }
    private void replaceLast() {
        lastInQueue = 0;
    }
    @Override
    public int getLimit() {
        return this.limit;
    }
    @Override
    public boolean isFull() {
        return lastInQueue == firstInQueue - 1 || (lastInQueue == limit - 1 && firstInQueue == -1);
    }

    @Override
    public void fillWithRandomValues(int num) {

    }

    @Override
    public int getSize() {
        if (isFull()) {
            return limit;
        }
        int size = lastInQueue - firstInQueue;
        return lastInQueue >= firstInQueue ? size : limit - size;
    }

    @Override
    public boolean isEmpty() {
        return lastInQueue == firstInQueue;
    }

    @Override
    public void pushQ(T v) {
        if (!isFull()) {
            lastInQueue++;
            checkLast();
            array[lastInQueue] = v;
        }
        else {
            System.err.println("Queue is out of bounds");
            this.doubleBounds();
            this.pushQ(v);
        }
    }
    private void doubleBounds() {
        limit *= 2;
        this.array = Arrays.copyOf(this.array, limit);
    }
    @Override
    public T peekQ() {
        assert firstInQueue != -1;
        return array[firstInQueue];
    }

    @Override
    public T popQ() {
        assert !isEmpty();
        checkFirst();
        T result = array[++firstInQueue];

        return result;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (T t: array) {
            builder.append(" ");
            builder.append(t);
        }
        builder.append("]");
        return builder.toString();
    }
}
