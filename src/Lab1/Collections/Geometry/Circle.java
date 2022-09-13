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
    public Circle(Point dote, double radius) {
        this.center = dote;
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
}
