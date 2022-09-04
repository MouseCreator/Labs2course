package Lab1.Collections;

import Lab1.Collections.Collection;

public interface Queue<T> extends Collection<T> {
    void pushQ(T v);
    T peekQ();
    T popQ();
}
