package Lab1.Collections.IntCollections;


public class StackList implements Stack {
    public StackList(Class c) {
        this.begin = null;
        this.size = 0;
        this.dataType = c;
    }
    public StackList(Object element) {
        this.begin = null;
        this.size = 0;
        this.dataType = element.getClass();
        this.push(element);
    }
    private ListNode begin;

    final Object dataType;
    private int size;
    @Override
    public void fillWithRandomValues(int num) {

    }

    @Override
    public int getSize() {
        return this.size;
    }
    public ListNode getBegin() {
        return this.begin;
    }
    public void setBegin(ListNode begin) {
        this.begin = begin;
    }
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void pushSeveral(Object... objects) {
        for (Object object : objects) {
            this.push(object);
        }
    }

    @Override
    public void push(Object object) {
        if (isValid(object)) {
            this.begin = new ListNode(object, this.begin);
            this.size++;
        }
        else {
            ErrorInformer.printError(ErrorCodes.INVALID_DATA_TYPE);
        }
    }

    @Override
    public Object peek() {
        return this.isEmpty() ? 0 : this.begin.getValue();
    }

    @Override
    public Object pop() {
        try {
            Object result = this.begin.getValue();
            this.begin = this.begin.getNext();
            this.size--;
            return  result;
        } catch (NullPointerException e) {
            return 0;
        }
    }
    private boolean isValid(Class c) {
        return this.dataType.equals(c);
    }
    private boolean isValid(Object object) {
        return this.dataType.equals(object.getClass());
    }




}
