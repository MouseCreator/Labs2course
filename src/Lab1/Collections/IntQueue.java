package Lab1.Collections;

public class IntQueue extends IntList {
    private IntNode begin;
    private IntNode end;
    private int size;

    IntQueue() {
        this.size = 0;
        this.begin = null;
    }
    IntQueue(int... ints) {
        this.pushSeveral(ints);
    }
    @Override
    public void push(int v) {
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

    @Override
    public int pop() {
        try {
            int result = this.begin.getValue();
            this.size--;
            this.begin = this.begin.getNext();
            return result;
        }
        catch (NullPointerException e) {
            return 0;
        }
    }

}
