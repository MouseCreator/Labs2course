package Lab1.Collections.Collect.Graphs;

public class NodeIndexList {
    private final boolean[] nodes;

    private int size;
    private int maxIndex;
    public NodeIndexList(int size) {
        this.nodes = new boolean[size];
        this.size = 0;
        this.maxIndex = 0;
    }

    public int size() {
        return this.size;
    }

    public int maxIndex() {
        return maxIndex;
    }

    public int getFirstFree() {
        for (int i = 0; i < nodes.length; i++) {
            if (!nodes[i]) {
                return i;
            }
        }
        return -1;
    }
    private int getLastReserved() {
        for (int i = nodes.length - 1; i >= 0; i--) {
            if (nodes[i]) {
                return i;
            }
        }
        return -1;
    }
    public void reserve(int i) {
        if (isAvailable(i)) {
            nodes[i] = true;
            ++size;
        }
        if (i > maxIndex) {
            maxIndex = i;
        }
    }
    public void free(int i) {
        if (isAvailable(i)) {
            nodes[i] = false;
            --size;
        }
        if (i == maxIndex) {
            maxIndex = getLastReserved();
        }
    }
    public boolean isAvailable(int index) {
        return index < nodes.length;
    }
    public boolean isReserved(int i) {
        if (isAvailable(i)) {
            return nodes[i];
        }
        return false;
    }
}
