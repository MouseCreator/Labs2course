package Lab1.Collections.Collect;

public interface Stack<T> extends Collection<T> {
    Stack<T> pushFront(T v) throws OversizeException;
    T peekFront() throws EmptyException, NullPointerException;
    T popFront() throws EmptyException, NullPointerException;
}
