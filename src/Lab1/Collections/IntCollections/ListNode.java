package Lab1.Collections.IntCollections;

public class ListNode<T> {
    T value;
    ListNode<T> next;
    public ListNode(T v, ListNode<T> from) {
        this.value = v;
        this.next = from;
    }
    public ListNode(T v) {
        this.value = v;
        this.next = null;
    }
    T getValue() {
        return value;
    }
    void setValue(T value) {
        this.value = value;
    }
    ListNode<T> getNext() {
        return this.next;
    }
    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
    void setNext(ListNode<T> node) {
        this.next = node;
    }
}
