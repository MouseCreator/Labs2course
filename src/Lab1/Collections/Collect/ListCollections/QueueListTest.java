package Lab1.Collections.Collect.ListCollections;

import Lab1.Collections.Collect.EmptyException;
import Lab1.Collections.Geometry.Circle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class QueueListTest {

    QueueList<Circle> queue;
    Circle[] circles;

    @BeforeEach
    void createQueue() {
        queue = new QueueList<>();
        circles = new Circle[3];
        circles[0] = new Circle(0, 1, 2);
        circles[1] = new Circle(1, 2, 3);
        circles[2] = new Circle(2, 3, 4);
    }
    @Test
    void pushBack() {

        pushCircles();

        assertEquals(Arrays.toString(circles), queue.toString());
    }

    void pushCircles() {
        IntStream.range(0, circles.length).forEach(i -> queue.pushBack(circles[i]));
    }
    @Test
    void popBack() {
        pushCircles();
        for (Circle i : circles) {
            assertEquals(i, queue.popBack());
        }
        assertThrows(EmptyException.class, queue::popBack);
    }
}