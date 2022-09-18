package Lab1.Collections.Collect.Graphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrientedGraphMatrixTest {
    @Test
    void isConnectedTest() {
        OrientedGraphMatrix<Integer> graph = new OrientedGraphMatrix<>(5);

        graph.addNode(0);
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0,2);
        graph.addEdge(1,3);
        //4 is isolated!
        assertFalse(graph.isConnected());

        graph.addEdge(2, 4);
        //now i'm connected
        assertTrue(graph.isConnected());

        assertFalse(graph.isStrongConnected());
        graph.addEdge(4, 0);
        graph.addEdge(3, 4);
        assertTrue(graph.isStrongConnected());

    }
}