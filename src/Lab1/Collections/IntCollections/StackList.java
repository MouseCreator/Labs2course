package Lab1.Collections.IntCollections;

/* Probably should make an abstract list with double-connected nodes and each data type would use it*/
public class StackList<T> implements Stack<T> {
    private final AbstractList<T> list;
    private ListNode<T> begin;
    private int size;
    public StackList() {
        this.begin = null;
        this.size = 0;
        list = new AbstractList<>();
    }

    @Override
    public void fillWithRandomValues(int num) {

    }

    @Override
    public int getSize() {
        return this.size;
    }
    public boolean isEmpty() {
        return this.size == 0;
    }

    public void pushS(T t) {
        this.begin = list.push(begin, t);
        this.size++;
    }

    public T peekS() {
        return list.peek(begin);
    }

    public T popS() {
        T result = list.peek(begin);
        this.begin = list.pop(begin);
        this.size--;
        return result;
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
