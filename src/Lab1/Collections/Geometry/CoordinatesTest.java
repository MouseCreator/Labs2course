package Lab1.Collections.Geometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CoordinatesTest {
    @Test
    void intersectsLineCircle() {
        Line line = new Line(0, 7);
        Circle circle = new Circle(4, 2, 5);
        Dot[] intersection = Coordinates.intersectsLineCircle(line, circle);
        Dot[] expected = new Dot[2];
        expected[0] = new Dot(4, 7);
        expected[1] = null;
        assertArrayEquals(expected, intersection);

        line.setK(-0.8);

        intersection = Coordinates.intersectsLineCircle(line, circle);
        expected[0] = new Dot(1.131, 6.095);
        expected[1] = new Dot(8.625, 0.1);
        assertArrayEquals(expected, intersection);
        line.setB(-2.5);

        intersection = Coordinates.intersectsLineCircle(line, circle);
        expected[0] = null;
        expected[1] = null;
        assertArrayEquals(expected, intersection);
    }
}