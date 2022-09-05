package Lab1.Collections.Collect;

public interface Stack<T> extends Collection<T> {
    Stack<T> pushS(T v) throws OversizeException;
    T peekS() throws EmptyException, NullPointerException;
    T popS() throws EmptyException, NullPointerException;
}
