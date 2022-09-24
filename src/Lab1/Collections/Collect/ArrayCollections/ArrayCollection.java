package Lab1.Collections.Collect.ArrayCollections;

public abstract class ArrayCollection<T> {
    public abstract int getLimit();
    public abstract boolean isFull();
    public int ABSOLUTE_ELEMENT_LIMIT = 16_777_216;
}
