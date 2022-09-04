package Lab1.Collections.ArrayCollections;

import Lab1.Collections.Stack;

import java.util.Arrays;


public class StackArray<T> implements Stack<T>, ArrayCollection {
    private int lastIndex;
    private int limit;
    private T[] array;
    public StackArray() {
        limit = 1024;
        lastIndex = -1;
        initArray();
    }
    public StackArray(int limit) {
        this.limit = limit;
        lastIndex = -1;
        initArray();
    }
    private void initArray() {
        this.array = (T[])new Object[limit];
    }
    @Override
    public void fillWithRandomValues(int num) {

    }

    @Override
    public int getSize() {
        return lastIndex + 1;
    }

    @Override
    public boolean isEmpty() {
        return lastIndex == -1;
    }

    @Override
    public void pushS(T v) {
        if (lastIndex < limit) {
            lastIndex++;
            this.array[lastIndex] = v;
        }
        else {
            System.err.println("Stack out of bounds");
            this.doubleBounds();
            this.pushS(v);
        }
    }

    private void doubleBounds() {
        limit *= 2;
        this.array = Arrays.copyOf(this.array, limit);
    }

    @Override
    public T peekS() {
        assert !isEmpty();
        return array[lastIndex];
    }

    @Override
    public T popS() {
        assert !isEmpty();
        return array[lastIndex--];
    }

    @Override
    public int getLimit() {
        return this.limit;
    }

    public boolean isFull() {
        return this.lastIndex == limit - 1;
    }
}
