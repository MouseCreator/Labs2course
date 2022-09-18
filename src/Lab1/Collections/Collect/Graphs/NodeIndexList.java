package Lab1.Collections.Collect.Graphs;

public class NodeIndexList {
    private boolean[] nodes;

    private int size;
    public NodeIndexList(int size) {
        this.nodes = new boolean[size];
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public int getFirstFree() {
        for (int i = 0; i < nodes.length; i++) {
            if (!nodes[i]) {
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
    }
    public void free(int i) {
        if (isAvailable(i)) {
            nodes[i] = false;
            --size;
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
