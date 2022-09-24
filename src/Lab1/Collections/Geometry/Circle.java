package Lab1.Collections.Geometry;

public class Circle extends Figure{
    private double radius;
    private Point center;

    public Point getCenter() {
        return center;
    }
    public void setCenter(Point point) {
        this.center = point;
    }
    public double getRadius() {
        return this.radius;
    }
    public void setRadius(double r) {
        this.radius = r;
    }

    public Circle (double x, double y, double radius) {
        this.center = new Point(x, y);
        this.radius = radius;
    }
    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }
    @Override
    public String toString() {
        return "" + center.toString() + ", " + radius;
    }
    @Override
    public String toEquation() {
        return String.format("(x - . 2%f)^2 + (y - . 2%f)^2 = . 2%f", center.x, center.y, radius);
    }
    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (this.getClass() != other.getClass())
            return false;
        Circle c = (Circle) other;
        return Coordinates.doubleEquals(c.radius, radius) && c.center.equals(center);
    }

    /**
     * @return true if circle contains {@param point} and false if it doesn't
     */
    public boolean contains(Point point) {
        double x = point.x;
        double y = point.y;
        return Coordinates.doubleEquals(Math.pow(x - this.center.x, 2) + Math.pow(y - this.center.y, 2), Math.pow(radius, 2));
    }
    public Point opposite(Point to) {
        return CoordinatesMath.move(center, new Vector2D(to, center));
    }

}
