package Lab1.Collections.Collect.ArrayCollections;

public abstract class ArrayCollection<T> {
    public abstract int getLimit();
    public abstract boolean isFull();

    public int ABSOLUTE_ELEMENT_LIMIT = 2_097_152;
}
