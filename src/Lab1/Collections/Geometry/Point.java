package Lab1.Collections.Geometry;

public class Point {
    public double x;
    public double y;

    Point(double x, double y) {
        assert (Double.isFinite(x) && Double.isFinite(y));
        this.x = x;
        this.y = y;
    }
    Point() {
        this. x = 0;
        this. y = 0;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (this.getClass() != other.getClass())
            return false;
        Point d = (Point) other;
        return Coordinates.doubleEquals(x, d.x) && Coordinates.doubleEquals(y, d.y);
    }
}
