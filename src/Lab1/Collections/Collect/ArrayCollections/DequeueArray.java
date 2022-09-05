package Lab1.Collections.Collect.ArrayCollections;

import Lab1.Collections.Collect.EmptyException;
import Lab1.Collections.Collect.OversizeException;
import Lab1.Collections.Collect.Stack;
import Lab1.Collections.Collect.Queue;

public class DequeueArray<T> implements Stack<T>, Queue<T> {
    private int limit;
    private T[] array;
    private int begin;
    private int end;

    public DequeueArray() {
        this.limit = 1024;
        this.initArray();
        this.initPointers();
    }
    public DequeueArray(int limit) {
        this.limit = limit;
        this.initArray();
        this.initPointers();
    }
    private void initArray() {
        this.array = (T[]) new Object[limit];
    }
    private void initPointers() {
        int mid = limit / 2;
        end = mid;
        begin = mid + 1;
    }
    @Override
    public void fillWithRandomValues(int num) {

    }

    @Override
    public int getSize() {
        return end - begin + 1;
    }

    @Override
    public boolean isEmpty() {
        return begin == end + 1;
    }
    private boolean indexOutOfBounds(int index) {
        return index < 0 || index >= limit;
    }
    private void doubleArray() throws OversizeException {
        if(limit > Integer.MAX_VALUE / 2)
            throw new OversizeException("Array limit is out of bounds.");
        this.array = copyArray();
        limit *= 2;
    }
    private T[] copyArray() {
        final int addToEachBound = limit / 2;
        T[] copy = (T[]) new Object[limit*2];
        this.begin += addToEachBound;
        this.end += addToEachBound;
        for (int i = 0; i < array.length; i++) {
            copy[addToEachBound+i] = array[i];
        }
        return copy;
    }

    @Override
    public DequeueArray<T> pushQ(T v) throws OversizeException {
        begin--;
        checkBegin();
        array[begin] = v;
        return this;
    }
    private void checkBegin() throws OversizeException{
        if (indexOutOfBounds(begin)) {
            doubleArray();
        }
    }
    @Override
    public T peekQ() throws EmptyException {
        if (isEmpty())
            throw new EmptyException("Dequeue is empty");
        return array[begin];
    }

    @Override
    public T popQ() throws EmptyException {
        if (isEmpty())
            throw new EmptyException("Dequeue is empty");
        return array[begin++];
    }

    @Override
    public DequeueArray<T> pushS(T v) throws OversizeException {
        end++;
        checkEnd();
        array[end] = v;
        return this;
    }
    private void checkEnd() throws OversizeException{
        if (indexOutOfBounds(end)) {
            doubleArray();
        }
    }
    @Override
    public T peekS() throws EmptyException{
        if (isEmpty())
            throw new EmptyException("Dequeue is empty");
        return array[end];
    }

    @Override
    public T popS() throws EmptyException {
        if (isEmpty())
            throw new EmptyException("Dequeue is empty");
        return array[end--];
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (int i = begin; i <= end; i++) {
            builder.append(" ").append(array[i]);
        }
        builder.append(" ]");
        return builder.toString();
    }
}
