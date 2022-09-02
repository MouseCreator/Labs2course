package Lab1.Collections;

public class IntList implements IntCollection {
    public void fillWithRandomValues(int num) {
        for (int i = 0; i < num; i++) {
            this.push(Generator.getInt());
        }
    }
    public void pushSeveral(int... ints) {
        if (ints != null) {
            for (int i : ints) {
                this.push(i);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        IntNode node = this.getBegin();
        while (node != null) {
            builder.append(" ");
            builder.append(node);
            node = node.getNext();
        }
        builder.append("]");
        return builder.toString();
    }
    public void push(int v) {

    }
    public int peek() {
        IntNode begin = this.getBegin();
        return begin != null ? begin.getValue() : 0;
    }
    public int pop() {
        try {
            IntNode begin = this.getBegin();
            int result = begin.getValue();
            this.setBegin(begin.getNext());
            return result;
        }
        catch (NullPointerException e) {
            return 0;
        }
    }
    public IntNode getBegin() {
        return null;
    }
    public void setBegin(IntNode begin) {

    }
}
