package Lab1.Collections.IntCollections;

import Lab1.Collections.Generator;

public class QueueList implements Queue {
    private ListNode begin;
    private ListNode end;
    private int size;
    final Object dataType;
    public QueueList(Class c) {
        this.size = 0;
        this.begin = null;
        this.dataType = c;
    }

    public void pushSeveral(Object objects) {

    }

    public void push(Object v) {
        ListNode toAdd = new ListNode(v);
        if (this.end != null) {
            this.end.setNext(toAdd);
            this.end = this.end.getNext();
        }
        else {
            this.begin = this.end = toAdd;
        }
        this.size++;
    }


    public Object peek() {
        ListNode begin = this.begin;
        return begin != null ? begin.getValue() : null;
    }

    public Object pop() {
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
        for (int i = 0; i < num; i++) {
            this.push(Generator.getInt());
        }
    }
    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
    private boolean isValid(Class c) {
        return this.dataType.equals(c);
    }
    private boolean isValid(Object object) {
        return this.dataType.equals(object.getClass());
    }
}
