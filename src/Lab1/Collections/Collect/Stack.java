package Lab1.Collections.Collect;

public interface Stack<T> extends Collection<T> {

    /**
     *
     * @param v is an element to add
     * @return this
     * @throws OversizeException if the element cannot be placed
     */
    Stack<T> pushFront(T v) throws OversizeException;

    /**
     *
     * @return front element of the stack
     * @throws EmptyException if the stack is empty
     */
    T peekFront() throws EmptyException;

    /**
     * Removes the front element of the stack
     * @return front element of the stack
     * @throws EmptyException if the stack is empty
     */
    T popFront() throws EmptyException;
}
