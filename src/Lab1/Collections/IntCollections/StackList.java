package Lab1.Collections.IntCollections;

/* Probably should make an abstract list with double-connected nodes and each data type would use it*/
public class StackList<T> implements Stack<T> {
    public StackList() {
        this.begin = null;
        this.size = 0;
    }
    private ListNode<T> begin;
    private int size;
    @Override
    public void fillWithRandomValues(int num) {

    }

    @Override
    public int getSize() {
        return this.size;
    }
    public ListNode<T> getBegin() {
        return this.begin;
    }
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void push(T t) {
        this.begin = new ListNode<>(t, this.begin);
        this.size++;
    }

    @Override
    public T peek() {
        return this.isEmpty() ? null : this.begin.getValue();
    }

    @Override
    public T pop() {
        try {
            T result = this.begin.getValue();
            this.begin = this.begin.getNext();
            this.size--;
            return result;
        } catch (NullPointerException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        ListNode<T> node = this.begin;
        StringBuilder builder = new StringBuilder("[");
        while(node != null) {
            builder.append(" ");
            builder.append(node.getValue().toString());
            node = node.getNext();
        }
        builder.append(" ]");
        return builder.toString();
    }
}
