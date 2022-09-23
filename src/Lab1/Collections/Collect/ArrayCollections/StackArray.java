package Lab1.Collections.Collect.ArrayCollections;

import Lab1.Collections.Collect.OversizeException;
import Lab1.Collections.Collect.Stack;

import java.util.Arrays;


public class StackArray<T> extends ArrayCollection implements Stack<T>  {
    private int lastIndex;
    private int limit;
    private T[] array;
    public StackArray() {
        limit = 128;
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
    public int getSize() {
        return lastIndex + 1;
    }

    @Override
    public boolean isEmpty() {
        return lastIndex == -1;
    }

    @Override
    public StackArray<T> pushFront(T v) throws OversizeException {
        if (lastIndex < limit) {
            lastIndex++;
            this.array[lastIndex] = v;
        }
        else {
            System.err.println("Stack out of bounds");
            this.doubleBounds();
            this.pushFront(v);
        }
        return this;
    }

    private void doubleBounds() throws OversizeException{
        if(limit > Integer.MAX_VALUE / 2)
            throw new OversizeException("Array limit is out of bounds.");
        limit *= 2;
        this.array = Arrays.copyOf(this.array, limit);
    }

    @Override
    public T peekFront() {
        assert !isEmpty();
        return array[lastIndex];
    }

    @Override
    public T popFront() {
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
