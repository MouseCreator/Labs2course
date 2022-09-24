package Lab1.Collections.Collect.LibraryCollections;

import Lab1.Collections.Collect.Stack;
import Lab1.Collections.Collect.Queue;

import java.util.ArrayDeque;

public class LibraryDeque<T> implements Stack<T>, Queue<T> {
    private final ArrayDeque<T> deque;
    LibraryDeque() {
        deque = new ArrayDeque<>();
    }
    @Override
    public int getSize() {
        return deque.size();
    }

    @Override
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    @Override
    public Stack<T> pushFront(T v) {
        deque.addFirst(v);
        return this;
    }

    @Override
    public T peekFront() {
        return deque.peekFirst();
    }

    @Override
    public T popFront() {
        return deque.removeFirst();
    }

    @Override
    public Queue<T> pushBack(T v){
        deque.addLast(v);
        return this;
    }

    @Override
    public T peekBack() {
        return deque.peekLast();
    }

    @Override
    public T popBack() {
        return deque.removeLast();
    }
}
