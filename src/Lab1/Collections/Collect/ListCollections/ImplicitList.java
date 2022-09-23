package Lab1.Collections.Collect.ListCollections;

import Lab1.Collections.Collect.EmptyException;
import Lab1.Collections.Collect.Nodes.ListNode;

class ImplicitList<T> {
    /**
     *
     * @param position is the parent node
     * @param data data to store in the node
     * @return the added node
     * The added node will be next to the parent node
     */
    public ListNode<T> pushFront(ListNode<T> position, T data) {
        return new ListNode<>(data, position);
    }

    /**
     *
     * @param position is the parent node
     * @param data data to store in the node
     * @return the added node
     * The added will be previous to the parent node
     */
    public ListNode<T> pushBack(ListNode<T> position, T data) {
        ListNode<T> toAdd = new ListNode<>(data, null);
        if (position != null) {
            position.setNext(toAdd);
        }
        return toAdd;
    }

    /**
     *
     * @param position node to get data from
     * @return value, stored in the node
     * @throws EmptyException if received null as {@param position}
     */
    public T peek(ListNode<T> position) throws EmptyException {
        if (position == null) {
            throw new EmptyException();
        }
        return position.getValue();
    }

    /**
     *
     * @param position is the node to remove
     * @return next to the {@param position}
     * @throws EmptyException if received null as {@param positon}
     */
    public ListNode<T> pop(ListNode<T> position) throws EmptyException {
        if (position == null) {
            throw new EmptyException();
        }
        return position.getNext();
    }
}
