package Lab1.Collections.IntCollections;

import Lab1.Collections.CollectionT;

public interface Stack extends CollectionT {
    void pushSeveralFront(Object objects);
    void pushFront(Object v);
    Object peekFront();
    Object popFront();
}
