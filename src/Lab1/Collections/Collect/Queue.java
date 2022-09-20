package Lab1.Collections.Collect;
//Comment
public interface Queue<T> extends Collection<T> {
    Queue<T> pushBack(T v) throws OversizeException;
    T peekBack() throws EmptyException, NullPointerException;
    T popBack() throws EmptyException, NullPointerException;
}
