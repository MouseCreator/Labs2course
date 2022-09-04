package Lab1.Collections.Collect.ListCollections;

import Lab1.Collections.Collect.Nodes.DoubleListNode;

class ImplicitDoubleList<T> {
    public ImplicitDoubleList() {

    }
    public DoubleListNode<T> pushFirst(DoubleListNode<T> position, T data) {
        DoubleListNode<T> toAdd = new DoubleListNode<>(data);
        toAdd.setNext(position);
        if (position != null)
            position.setPrev(toAdd);
        return toAdd;
    }
    public DoubleListNode<T> pushLast(DoubleListNode<T> position, T data) {
        DoubleListNode<T> toAdd = new DoubleListNode<>(data);
        toAdd.setPrev(position);
        if (position != null)
            position.setNext(toAdd);
        return toAdd;
    }

    public T peek(DoubleListNode<T> position) {
        assert position != null;
        return position.getValue();
    }
    public DoubleListNode<T> pop(DoubleListNode<T> position) {
        assert position != null;
        if (position.hasNext()) {
            DoubleListNode<T> nextNode = position.getNext();
            nextNode.setPrev(null);
            return nextNode;
        }
        else if (position.hasPrev()) {
            DoubleListNode<T> prevNode = position.getPrev();
            prevNode.setNext(null);
            return prevNode;
        }
        else {
            return null;
        }
    }
}
