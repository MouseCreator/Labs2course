package Lab1.Collections.Collect.LibraryCollections;

import java.util.Stack;

public class LibraryStack<T> implements Lab1.Collections.Collect.Stack<T> {
    private final Stack<T> stack;

    LibraryStack() {
        this.stack = new Stack<>();
    }


    @Override
    public int getSize() {
        return stack.size();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public Lab1.Collections.Collect.Stack<T> pushFront(T v) {
        stack.push(v);
        return this;
    }

    @Override
    public T peekFront() {
        return stack.peek();
    }

    @Override
    public T popFront() {
        return stack.pop();
    }
}
