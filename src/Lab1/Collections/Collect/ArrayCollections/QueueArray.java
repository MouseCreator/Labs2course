package Lab1.Collections.Collect.ArrayCollections;

import Lab1.Collections.Queue;

import java.util.Arrays;

public class QueueArray<T> implements Queue<T>, ArrayCollection{
    private int firstInQueue = 0;

    private int size = 0;
    private int lastInQueue = 0;

    public QueueArray() {
        limit = 1024;
        initArray();
    }
    public QueueArray(int limit) {

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
        return lastInQueue == firstInQueue && size != 0;
    }
    @Override
    public boolean isEmpty() {
        return lastInQueue == firstInQueue && size == 0;
    }
    @Override
    public void fillWithRandomValues(int num) {

    }

    @Override
    public int getSize() {
        return size;
    }



    @Override
    public void pushQ(T v) throws Exception {
        if (!isFull()) {
            array[lastInQueue] = v;
            lastInQueue++;
            checkLast();
            size++;
        }
        else {
            System.err.println("Queue is out of bounds");
            this.doubleBounds();
            this.pushQ(v);
        }
    }
    private void doubleBounds() throws Exception {
        if (limit / 2 > Integer.MAX_VALUE)
            throw new Exception("Array limit is out of bounds.");
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
        size--;
        T result = array[firstInQueue];
        firstInQueue++;
        checkFirst();

        return result;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (int i = firstInQueue; i != lastInQueue; i++) {
            if (i == limit) {
                i = 0;
            }
            builder.append(" ");
            builder.append(array[i]);
        }
        builder.append(" ]");
        return builder.toString();
    }
}