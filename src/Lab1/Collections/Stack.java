package Lab1.Collections;

import Lab1.Collections.Collect.Collection;

public interface Stack<T> extends Collection<T> {
    void pushS(T v) throws Exception;
    T peekS();
    T popS();
}
