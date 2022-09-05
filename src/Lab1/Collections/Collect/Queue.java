package Lab1.Collections.Collect;

import Lab1.Collections.Collect.Collection;

public interface Queue<T> extends Collection<T> {
    Queue<T> pushQ(T v) throws OversizeException;
    T peekQ() throws EmptyException, NullPointerException;
    T popQ() throws EmptyException, NullPointerException;
}
