package Lab1.Collections.Collect.ArrayCollections;

import Lab1.Collections.Collect.EmptyException;
import Lab1.Collections.Collect.OversizeException;
import Lab1.Collections.Collect.Queue;

import java.util.Arrays;

public class QueueArray<T> extends ArrayCollection<T> implements Queue<T> {
    private int firstInQueue = 0;

    private int size = 0;
    private int lastInQueue = 0;

    public QueueArray() {
        limit = 128;
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
    public int getSize() {
        return size;
    }



    @Override
    public QueueArray<T> pushBack(T v) throws OversizeException {
        if (!isFull()) {
            array[lastInQueue] = v;
            lastInQueue++;
            checkLast();
            size++;
        }
        else {
            this.doubleBounds();
            this.pushBack(v);
        }
        return this;
    }
    private void doubleBounds() throws OversizeException {
        if (limit * 2 > (ABSOLUTE_ELEMENT_LIMIT))
            throw new OversizeException("Array limit is out of bounds");
        if (lastInQueue == 0) {
            lastInQueue = limit;
        }
        limit *= 2;
        System.out.println(limit);
        this.array = Arrays.copyOf(this.array, limit);
    }
    @Override
    public T peekBack() throws EmptyException {
        if (isEmpty()) {
            throw new EmptyException("Queue is empty");
        }
        return array[firstInQueue];
    }

    @Override
    public T popBack() throws EmptyException {
       if (isEmpty())
           throw new EmptyException("Queue is empty");
        size--;
        T result = array[firstInQueue];
        firstInQueue++;
        checkFirst();

        return result;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        boolean loop = this.isFull();
        for (int i = firstInQueue; i != lastInQueue || loop; i++) {
            if ( i != firstInQueue) {
                builder.append(", ");
            }
            if (i == limit) {
                i = -1;
                loop = false;
                continue;
            }
            builder.append(array[i]);
        }
        builder.append("]");
        return builder.toString();
    }
}
