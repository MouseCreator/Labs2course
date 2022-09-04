package Lab1.Collections.IntCollections;

public class QueueList<T> implements Queue<T> {
    private ListNode<T> begin;
    private ListNode<T> end;
    private int size;
    public QueueList() {
        this.size = 0;
        this.begin = null;
    }


    public void push(T v) {
        ListNode<T> toAdd = new ListNode<>(v);
        if (this.end != null) {
            this.end.setNext(toAdd);
            this.end = this.end.getNext();
        }
        else {
            this.begin = this.end = toAdd;
        }
        this.size++;
    }

    public T peek() {
        ListNode<T> begin = this.begin;
        return begin != null ? begin.getValue() : null;
    }

    public T pop() {
        try {
            T result = this.begin.getValue();
            this.size--;
            this.begin = this.begin.getNext();
            return result;
        }
        catch (NullPointerException e) {
            return null;
        }
    }

    public void fillWithRandomValues(int num) {

    }
    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
