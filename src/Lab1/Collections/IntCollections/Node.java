package Lab1.Collections.IntCollections;

public abstract class Node<T> {
    private T value;
    Node(T v) {
        this.value = v;
    }
    public T getValue() {
        return this.value;
    }
    public void setValue(T value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value.toString();
    }
}
