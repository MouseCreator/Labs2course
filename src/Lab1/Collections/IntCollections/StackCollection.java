package Lab1.Collections.IntCollections;


public class StackCollection<T> implements Stack {
    public StackCollection() {
        this.begin = null;
        this.size = 0;
    }
    private IntNode begin;
    private int size;
    @Override
    public void fillWithRandomValues(int num) {

    }

    @Override
    public int getSize() {
        return this.size;
    }


    public void push(T v) {
        this.begin = new IntNode(v, this.begin);
        this.size++;
    }
    public Object pop() {
        try {
            IntNode begin = this.getBegin();
            Object result = begin.getValue();
            this.setBegin(begin.getNext());
            this.size--;
            return result;
        }
        catch (NullPointerException e) {
            return 0;
        }
    }


    public IntNode getBegin() {
        return this.begin;
    }
    public void setBegin(IntNode begin) {
        this.begin = begin;
    }
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void pushSeveralFront(Object objects) {

    }

    @Override
    public void pushFront(Object v) {
        this.begin = new IntNode(v, this.begin);
        this.size++;
    }

    @Override
    public Object peekFront() {
        return this.isEmpty() ? 0 : this.begin.getValue();
    }

    @Override
    public Object popFront() {
        try {
            Object result = this.begin.getValue();
            this.begin = this.begin.getNext();
            this.size--;
            return  result;
        } catch (NullPointerException e) {
            return 0;
        }
    }



}
