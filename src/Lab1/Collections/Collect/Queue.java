package Lab1.Collections.Collect;
//Comment
public interface Queue<T> extends Collection<T> {
    /**
     *
     * @param v the element to add to the front of the queue
     * @return this
     * @throws OversizeException if new element cannot be places
     */
    Queue<T> pushBack(T v) throws OversizeException;
    /**
     * @return back element of the queue
     * @throws EmptyException if the queue is empty
     */
    T peekBack() throws EmptyException;
    /**
     * Removes the back element of the queue
     * @return back element of the queue
     * @throws EmptyException if the queue is empty
     */
    T popBack() throws EmptyException;
}
