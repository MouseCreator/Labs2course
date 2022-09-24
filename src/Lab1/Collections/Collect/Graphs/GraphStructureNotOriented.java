package Lab1.Collections.Collect.Graphs;
public class GraphStructureNotOriented<T> extends GraphStructureOriented<T> {
    public GraphStructureNotOriented() {
        super();
    }

    @Override
    public void addEdge(T from, T to, int weight) {
        super.addEdge(from, to, weight);
        super.addEdge(to, from, weight);
    }
    @Override
    public void addEdge(T from, T to) {
        super.addEdge(from, to);
        super.addEdge(to, from);
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
    public boolean hasCycle() {
        return super.hasStrongCycle();
    }

    public GraphStructureNotOriented<T> spanningTree() {
        if (!this.isStrongConnected())
            return null;
        GraphStructureNotOriented<T> tree = new GraphStructureNotOriented<>();
        addNodesToSpanningTree(tree);
        SortedEdgeList<T> allEdges = initEdgeList();
        buildSpanningTree(tree, allEdges);
        return tree;
    }

    private void addNodesToSpanningTree(GraphStructureNotOriented<T> tree) {
        for (T key : nodes.keySet()) {
            tree.addNode(key);
        }
    }
    private void buildSpanningTree(GraphStructureNotOriented<T> tree, SortedEdgeList<T> allEdges) {
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
        for (T key : nodes.keySet()) {
            list.add(key, nodes.get(key));
        }
        return list;
    }
    public int getWeight() {
        SortedEdgeList<T> list = initEdgeList();
        int sum = 0;
        while (!list.empty()) {
            sum += list.pop().weight;
        }
        return sum / 2; //each edge occurs twice: (A->B) & (B->A)
    }
}
