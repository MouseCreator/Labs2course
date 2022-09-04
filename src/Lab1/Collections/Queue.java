package Lab1.Collections;

import Lab1.Collections.Collect.Collection;

public interface Queue<T> extends Collection<T> {
    void pushQ(T v) throws Exception;
    T peekQ();
    T popQ();
}
