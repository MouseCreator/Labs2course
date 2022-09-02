package Lab1.Collections.IntCollections;

import Lab1.Collections.CollectionT;

public interface Queue extends CollectionT {
    void pushSeveral(Object objects);
    void push(Object v);
    Object peek();
    Object pop();
}
