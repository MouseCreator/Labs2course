package Lab1.Collections.Collect.Graphs;

import Lab1.Collections.Geometry.Circle;
import Lab1.Collections.Geometry.Figure;
import Lab1.Collections.Geometry.GenLine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphMatrixOrientedTest {
    @Test
    void isConnectedTest() {
        GraphMatrixOriented<Integer> graph = new GraphMatrixOriented<>(5);

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
        assertFalse(graph.isConnectedWithAll(0));

        graph.addEdge(2, 4);
        //now i'm connected
        assertTrue(graph.isConnectedWithAll(0));

        assertFalse(graph.isStrongConnected());
        graph.addEdge(4, 0);
        graph.addEdge(3, 4);
        assertTrue(graph.isStrongConnected());

    }
    @Test
    void findDistanceTest() {
        GraphMatrixOriented<Figure> graph = new GraphMatrixOriented<>(5);
        GenLine[] lines = new GenLine[5];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = new GenLine(1, 0, i);
            graph.addNode(lines[i]);
        }
        graph.addEdge(lines[0], lines[1], 1);
        graph.addEdge(lines[0], lines[2], 5);
        graph.addEdge(lines[1], lines[3], 2);
        graph.addEdge(lines[2], lines[3], 1);
        graph.addEdge(lines[3], lines[2], 1);
        graph.addEdge(lines[2], lines[4], 2);
        graph.addEdge(lines[3], lines[4], 4);

        assertEquals(6, graph.getDistance(lines[0], lines[4]));
    }
}