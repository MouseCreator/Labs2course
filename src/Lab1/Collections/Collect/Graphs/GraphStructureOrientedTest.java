package Lab1.Collections.Collect.Graphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphStructureOrientedTest {
    @Test
    void isConnectedTest() {
        GraphStructureOriented<Double> graph = new GraphStructureOriented<Double>();

        graph.addNode(4.44);
        graph.addNode(2.22);
        graph.addNode(1.11);
        graph.addNode(3.33);

        graph.addEdge(4.44, 2.22);
        graph.addEdge(2.22, 1.11);
        graph.addEdge(1.11, 4.44);

        assertFalse(graph.isConnectedWithAll(4.44));
        assertFalse(graph.isStrongConnected());

        graph.addEdge(4.44, 3.33);

        assertTrue(graph.isConnectedWithAll(4.44));
        assertFalse(graph.isStrongConnected());

        graph.addEdge(3.33, 1.11);

        assertTrue(graph.isConnectedWithAll(4.44));
        assertTrue(graph.isStrongConnected());
    }

}