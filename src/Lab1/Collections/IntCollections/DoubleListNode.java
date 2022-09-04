package Lab1.Collections.IntCollections;

public class DoubleListNode<T> extends Node<T> {
    DoubleListNode<T> next;
    DoubleListNode<T> prev;

    public DoubleListNode(T v) {
        super(v);
        this.next = null;
        this.prev = null;
    }

    public T peek(DoubleListNode<T> position) {
        assert position != null : "List is empty";
        return position.getValue();
    }
    public DoubleListNode<T> pop(DoubleListNode<T> position) {
        assert position != null : "List is empty";
        if (position.hasNext()) {
            DoubleListNode<T> nextNode = position.getNext();
            nextNode.setPrev(null);
            return nextNode;
        }
        else if (position.hasPrev()){
            DoubleListNode<T> prevNode = position.getPrev();
            prevNode.setNext(null);
            return prevNode;
        }
        else {
            return null;
        }
    }
    public DoubleListNode<T> getNext() { return this.next; }
    public void setNext(DoubleListNode<T> next) {
        this.next = next;
    }

    public boolean hasNext() {return next != null;}
    public boolean hasPrev() {return prev != null;}
    public DoubleListNode<T> getPrev() { return this.prev; }

    public void setPrev(DoubleListNode<T> node) {
        this.prev = node;
    }

}
