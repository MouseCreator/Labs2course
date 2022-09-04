package Lab1.Collections.IntCollections;

import Lab1.Collections.Collection;

public interface Queue<T> extends Collection<T> {
    void push(T v);
    T peek();
    T pop();
}
