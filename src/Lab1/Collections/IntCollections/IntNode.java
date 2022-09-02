package Lab1.Collections.IntCollections;

public class IntNode {
    Object value;
    IntNode next;
    public IntNode(Object v, IntNode from) {
        this.value = v;
        this.next = from;
    }
    public IntNode(Object v) {
        this.value = v;
        this.next = null;
    }
    Object getValue() {
        return value;
    }
    void setValue(int value) {
        this.value = value;
    }
    IntNode getNext() {
        return this.next;
    }
    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
    void setNext(IntNode node) {
        this.next = node;
    }
}
