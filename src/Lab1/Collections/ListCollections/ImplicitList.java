package Lab1.Collections.ListCollections;

import Lab1.Collections.Nodes.ListNode;

class ImplicitList<T> {

    public ListNode<T> push(ListNode<T> position, T data) {
        ListNode<T> toAdd = new ListNode<>(data, position);
        if (position != null)
            position.setNext(toAdd);
        return toAdd;
    }

    public T peek(ListNode<T> position) {
        assert position != null;
        return position.getValue();
    }
    public ListNode<T> pop(ListNode<T> position) {
        assert position != null;
        ListNode<T> nextNode = position.getNext();
        return nextNode;
    }
}
