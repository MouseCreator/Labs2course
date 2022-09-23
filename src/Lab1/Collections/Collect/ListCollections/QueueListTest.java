package Lab1.Collections.Collect.ListCollections;

import Lab1.Collections.Geometry.Circle;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class QueueListTest {

    QueueList<Circle> queue;
    Circle marker;

    @BeforeEach
    void createQueue() {
        queue = new QueueList<>();
        marker = new Circle(3,4, 5);
    }
    @Test
    void pushBack() {
        Circle[] circles = new Circle[3];
        circles[0] = marker;
        circles[1] = new Circle(1, 2, 3);
        circles[2] = new Circle(2, 3, 4);
        for (int i = 0; i < circles.length; i++) {
            queue.pushBack(circles[i]);
        }

        Collections.reverse(Arrays.asList(circles));
        assertEquals(Arrays.toString(circles), queue.toString());
    }
}