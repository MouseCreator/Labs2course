package Lab1.Collections;

public class IntNode extends StackNode{
    int value;
    IntNode next;
    public IntNode(int v, IntNode from) {
        this.value = v;
        this.next = from;
    }
    public IntNode(int v) {
        this.value = v;
        this.next = null;
    }
    int getValue() {
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
