package Lab1.Collections.IntCollections;

import Lab1.Collections.CollectionT;

public class IntQueue<T> implements Queue {
    private IntNode begin;
    private IntNode end;
    private int size;

    IntQueue() {
        this.size = 0;
        this.begin = null;
    }

    public void pushSeveralBack(Object objects) {

    }

    public void pushBack(Object v) {
        IntNode toAdd = new IntNode(v);
        if (this.end != null) {
            this.end.setNext(toAdd);
            this.end = this.end.getNext();
        }
        else {
            this.begin = this.end = toAdd;
        }
        this.size++;
    }
    public Object peekBack() {
        IntNode begin = this.begin;
        return begin != null ? begin.getValue() : null;
    }

    public Object popBack() {
        try {
            Object result = this.begin.getValue();
            this.size--;
            this.begin = this.begin.getNext();
            return result;
        }
        catch (NullPointerException e) {
            return 0;
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
