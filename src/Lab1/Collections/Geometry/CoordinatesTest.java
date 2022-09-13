package Lab1.Collections.Geometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CoordinatesTest {
    @Test
    void intersectsLineCircle() {
        Line line = new Line(0, 7);
        Circle circle = new Circle(4, 2, 5);
        PointFamily intersection = Coordinates.intersectsLineCircle(line, circle);
        PointFamily expected = new PointFamily();
        expected.add(new Point(4, 7));
        assertEquals(expected, intersection);

        line.setK(-0.8);

        intersection = Coordinates.intersectsLineCircle(line, circle);
        expected.clear();
        expected.add(new Point(1.131, 6.095));
        expected.add(new Point(8.625, 0.1));
        assertEquals(expected, intersection);
        line.setB(-2.5);

        intersection = Coordinates.intersectsLineCircle(line, circle);
        expected.clear();
        assertEquals(expected, intersection);
    }

    @Test
    void intersectsCircleCircle() {
        Circle circle1 = new Circle(7, 12, 5);
        Circle circle2 = new Circle(10, 6, 3);
        PointFamily intersection = Coordinates.intersectsCircleCircle(circle1, circle2);
        PointFamily expected = new PointFamily();
        expected.add(new Point(7.173, 7.003)).add(new Point(10.894, 8.864));
        assertEquals(expected, intersection);
    }
    @Test
    void isTangentTest() {
        Circle circle1 = new Circle(7, 12, 5);
        Circle circle2 = new Circle(7, 4, 3);
        Circle circle3 = new Circle(7, 4, 4);
        Line line = new Line(0, 1);

        assertTrue(Coordinates.isTangent(circle1, circle2));
        assertTrue(Coordinates.isTangent(line , circle2));
        assertFalse(Coordinates.isTangent(circle2, circle3));
        assertFalse(Coordinates.isTangent(line, circle1));
    }
}