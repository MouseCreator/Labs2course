package Lab1.Collections.Collect.ListCollections;

import Lab1.Collections.Collect.EmptyException;
import Lab1.Collections.Collect.Nodes.ListNode;

class ImplicitList<T> {

    public ListNode<T> push(ListNode<T> position, T data) {
        ListNode<T> toAdd = new ListNode<>(data, position);
        return toAdd;
    }

    public T peek(ListNode<T> position) throws EmptyException {
        if (position == null) {
            throw new EmptyException();
        }
        return position.getValue();
    }
    public ListNode<T> pop(ListNode<T> position) throws EmptyException {
        ListNode<T> nextNode = position.getNext();
        return nextNode;
    }
}
