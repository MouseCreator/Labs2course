package Lab1.Collections.Collect.Graphs;

public class NodeIndexList {
    private boolean[] nodes;
    public NodeIndexList(int size) {
        this.nodes = new boolean[size];
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
        if (i < nodes.length) {
            nodes[i] = true;
        }
    }
    public void free(int i) {
        if (i < nodes.length) {
            nodes[i] = false;
        }
    }
}
