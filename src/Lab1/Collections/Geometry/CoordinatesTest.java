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
}