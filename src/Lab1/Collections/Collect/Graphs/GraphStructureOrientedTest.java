package Lab1.Collections.Collect.Graphs;

import Lab1.Collections.Geometry.Circle;
import Lab1.Collections.Geometry.Figure;
import Lab1.Collections.Geometry.GenLine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphStructureOrientedTest {
    @Test
    void isConnectedTest() {
        GraphStructureOriented<Double> graph = new GraphStructureOriented<>();

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

    @Test
    void findDistanceTest() {
        GraphStructureOriented<Figure> graph = new GraphStructureOriented<>();

        GenLine[] lines = new GenLine[3];

        Circle[] circles = new Circle[2];

        for (int i = 0; i < lines.length; i++) {
            lines[i] = new GenLine(i, i+1, i+2);
            graph.addNode(lines[i]);
        }
        circles[0] = new Circle(10, 20, 30);
        circles[1] = new Circle(20,30,40);
        graph.addNode(circles[0]);
        graph.addNode(circles[1]);

        //longer, but less weight
        graph.addEdge(circles[0], lines[0], 2);
        graph.addEdge(lines[0], lines[1], 1);
        graph.addEdge(lines[1], circles[1], 3);

        //shorter, but more weight
        graph.addEdge(circles[0], lines[2], 1);
        graph.addEdge(lines[2], circles[1], 6);

        assertEquals(6, graph.getDistance(circles[0], circles[1]));
    }


}