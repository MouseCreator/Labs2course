package Lab1.Collections;

public interface Collection<T> {


    void push(T object);
    T peek();
    T pop();
    void fillWithRandomValues(int num);
    int getSize();
    boolean isEmpty();
}
