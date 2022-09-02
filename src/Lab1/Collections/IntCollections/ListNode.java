package Lab1.Collections.IntCollections;

public class ListNode {
    Object value;
    ListNode next;
    public ListNode(Object v, ListNode from) {
        this.value = v;
        this.next = from;
    }
    public ListNode(Object v) {
        this.value = v;
        this.next = null;
    }
    Object getValue() {
        return value;
    }
    void setValue(Object value) {
        this.value = value;
    }
    ListNode getNext() {
        return this.next;
    }
    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
    void setNext(ListNode node) {
        this.next = node;
    }
}
