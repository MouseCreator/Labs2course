package Lab1.Collections.Collect.Graphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphStructureNotOrientedTest {

    private GraphStructureNotOriented<Integer> graph;
    @BeforeEach
    void initGraph() {
        graph = new GraphStructureNotOriented<>();

        int[] nodes = {1, 2, 3, 4};
        for (int i : nodes) {
            graph.addNode(i);
        }
    }
    @Test
    void isConnectedTest() {

        graph.addEdge(1, 2);
        graph.addEdge(4, 3);
        assertFalse(graph.isStrongConnected());

        graph.addEdge(3,2);
        assertTrue(graph.isStrongConnected());
    }

    @Test
    void distanceTest() {

        graph.addEdge(1, 2);
        graph.addEdge(4, 3);
        graph.addEdge(3, 2);
        graph.addEdge(4, 1, 4);
        assertEquals(3, graph.getDistance(1, 4));
    }

    @Test
    void spanningTreeTest() {
        graph.addNode(5);

        graph.addEdge(1,5,1);
        graph.addEdge(4,5,3);
        graph.addEdge(1,4,2);
        graph.addEdge(1,2,1);
        graph.addEdge(2,3,1);
        graph.addEdge(4,3,4);

        assertEquals(5, graph.spanningTree().getWeight());
    }

}