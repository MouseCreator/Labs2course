package Lab1.Collections;

public interface IntCollection extends Collection{

    public void pushSeveral(int... ints);
    public void push(int v);
    public int peek();
    public int pop();

}
