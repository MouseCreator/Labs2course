package Lab1.Collections.IntCollections;

public class ListNode<T> extends Node<T> {

    ListNode<T> next;
    public ListNode(T v, ListNode<T> next) {
        super(v);
        this.next = next;
    }

    public ListNode<T> getNext() {
        return this.next;
    }
    public void setNext(ListNode<T> node) {
        this.next = node;
    }


    public boolean hasNext() {
        return this.next == null;
    }

}
