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
        expected.add(7.173, 7.003).add(10.894, 8.864);
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
    @Test
    void intersects() {
        //two lines intersect
        assertEquals(new PointFamily(new Point(-1, 2)),
                Coordinates.intersects(new GenLine(2, 4 , -6), new GenLine(3, -1, 5)));
        //two lines are parallel
        assertEquals(new PointFamily(),
                Coordinates.intersects(new GenLine(2, 4 , -6), new GenLine(4, 8, 10)));
        //test for b == 0 case
        assertEquals(new PointFamily(new Point(2, -2.25)),
                Coordinates.intersects(new GenLine(1, 0 , -2), new GenLine(4, 8, 10)));
        //test for a == 0 case
        assertEquals(new PointFamily(new Point(-6.5, 2)),
                Coordinates.intersects(new GenLine(0, 1 , -2), new GenLine(4, 8, 10)));
        //line is tangent to circle
        assertEquals(new PointFamily(new Point(3, 3)),
                Coordinates.intersects(new GenLine(0, 2 , -6), new Circle(3, 1, 2)));
        //line goes through  circle (b == 0)
        assertEquals(new PointFamily(new Point(3, 0.764), new Point(3, 5.236)),
                Coordinates.intersects(new GenLine(1, 0 , -3), new Circle(1, 3, 3)));
        //line goes through circle (b != 0)
        assertEquals(new PointFamily(new Point(1.03, -2.243), new Point(2.97, -1.757)),
                Coordinates.intersects(new GenLine(1, -4 , -10), new Circle(2, -2, 1)));
        //line passes by circle
        assertEquals(new PointFamily(),
                Coordinates.intersects(new GenLine(5, 4 , 0), new Circle(4, -2, 1)));
    }
}