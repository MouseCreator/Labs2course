package Lab1.Collections.Collect.Graphs;

import Lab1.Collections.Geometry.GenLine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphMatrixNotOrientedTest {
    private GraphMatrixNotOriented<GenLine> graph;
    private GenLine[] lines;
    @BeforeEach
    void initGraph() {
        graph = new GraphMatrixNotOriented<>(10);
        lines = new GenLine[5];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = new GenLine(1, i, i);
            graph.addNode(lines[i]);
        }
    }
    @Test
    void connectedTest() {

        graph.addEdge(lines[0], lines[1]);
        graph.addEdge(lines[0], lines[2]);
        graph.addEdge(lines[0], lines[3]);

        assertFalse(graph.isStrongConnected());
        assertFalse(graph.isConnectedWithAll(lines[0]));
        graph.addEdge(lines[4], lines[0]);
        graph.addEdge(lines[4], lines[1]);

        assertTrue(graph.isStrongConnected());
        assertTrue(graph.isConnectedWithAll(lines[0]));

    }
    @Test
    void hasCycleTest() {

        graph.addEdge(lines[0], lines[2]);
        graph.addEdge(lines[0], lines[3]);
        graph.addEdge(lines[0], lines[4]);

        assertFalse(graph.hasCycle());

        graph.addEdge(lines[4], lines[2]);

        assertTrue(graph.hasCycle());

    }
    void rhombusGraph() {
        graph.addEdge(lines[0], lines[1], 3);
        graph.addEdge(lines[1], lines[4], 7);

        graph.addEdge(lines[0], lines[2], 5);
        graph.addEdge(lines[2],lines[4], 2);

        graph.addEdge(lines[0], lines[3], 4);
        graph.addEdge(lines[3], lines[4], 4);
    }
    @Test
    void distanceTest() {

        rhombusGraph();

        assertEquals(7, graph.getDistance(lines[0], lines[4]));

    }

    @Test
    void spanningTreeTest() {

        rhombusGraph();

        assertEquals(14, graph.spanningTree().getWeight());

    }
}