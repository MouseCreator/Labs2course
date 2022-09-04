package Lab1.Collections;

import Lab1.Collections.Collection;

public interface Stack<T> extends Collection<T> {
    void pushS(T v);
    T peekS();
    T popS();
}