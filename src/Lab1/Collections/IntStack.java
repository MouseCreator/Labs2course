package Lab1.Collections;

public class IntStack extends IntList {
    public IntStack() {
        this.begin = null;
        this.size = 0;
    }
    public IntStack(int... ints) {
       this.pushSeveral(ints);
    }
    public void pushSeveral(int... ints) {
        if (ints != null) {
            for (int i : ints) {
                this.push(i);
            }
        }
    }
    private IntNode begin;
    private int size;

    public int getSize() {
        return this.size;
    }

    @Override
    public void push(int v) {
        this.begin = new IntNode(v, this.begin);
        this.size++;
    }


    @Override
    public IntNode getBegin() {
        return this.begin;
    }
    @Override
    public void setBegin(IntNode begin) {
        this.begin = begin;
    }
}
