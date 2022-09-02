package Lab1.Collections.IntCollections;

import Lab1.Collections.CollectionT;

public interface Queue extends CollectionT {
    void pushSeveralBack(Object objects);
    void pushBack(Object v);
    Object peekBack();
    Object popBack();
}
