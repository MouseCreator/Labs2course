package Lab1.Collections.Collect.Graphs;

public class GraphMatrixNotOriented<T> extends GraphMatrixOriented<T> {
    public GraphMatrixNotOriented(int maxNodes) {
        super(maxNodes);
    }
    @Override
    public void addEdge(T from, T to, int weight) {
        super.addEdge(from, to, weight);
        super.addEdge(to, from, weight);
    }
    @Override
    public void removeEdge(T from, T to) {
        super.removeEdge(from, to);
        super.removeEdge(to, from);
    }
    @Override
    public void changeEdgeWeight(T from, T to, int weight) {
        super.changeEdgeWeight(from, to, weight);
        super.changeEdgeWeight(to, from, weight);
    }
    @Override
    public boolean isStrongConnected() {
        return empty() ||
                isConnectedWithAll(this.getNodes()[0]);
    }
    @Override
    public boolean hasCycle() {
        return this.hasStrongCycle();
    }

    public GraphMatrixNotOriented<T> spanningTree() {
        if (!this.isStrongConnected())
            return null;
        GraphMatrixNotOriented<T> tree = new GraphMatrixNotOriented<>(getMaxNodes());
        addNodesToSpanningTree(tree);
        SortedEdgeList<T> allEdges = initEdgeList();
        buildSpanningTree(tree, allEdges);
        return tree;
    }

    private void addNodesToSpanningTree(GraphMatrixNotOriented<T> tree) {
        for (T key : getNodes()) {
            tree.addNode(key);
        }
    }
    private void buildSpanningTree(GraphMatrixNotOriented<T> tree, SortedEdgeList<T> allEdges) {
        while (!tree.isStrongConnected()) {
            SortedEdgeListNode<T> edge = allEdges.pop();
            tree.addEdge(edge.from, edge.to, edge.weight);
            if (tree.hasCycle()) {
                tree.removeEdge(edge.from, edge.to);
            }
        }
    }
    private SortedEdgeList<T> initEdgeList() {
        SortedEdgeList<T> list = new SortedEdgeList<>();
        T[] nodes = getNodes();
        for (int i = 0; i < nodes.length; i++)
            for (int j = 0; j < nodes.length; j++)
                if (hasEdge(nodes[i], nodes[j]))
                    list.add(nodes[i], nodes[j], getWeight(nodes[i], nodes[j]));
        return list;
    }
    public int getWeight() {
        SortedEdgeList<T> list = initEdgeList();
        int sum = 0;
        while (!list.empty()) {
            sum += list.pop().weight;
        }
        return sum / 2;
    }

}
