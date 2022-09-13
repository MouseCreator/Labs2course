package Lab1.Collections.Geometry;

public class Line extends Figure {
    private double k;
    private double b;

    public Line(double k, double b) {
        this.k = k;
        this.b = b;
    }
    public Line() {
        this.k = 0;
        this.b = 0;
    }
    public double getB() {
        return this.b;
    }
    public double getK() {
        return this.k;
    }
    public void setB(double b) {
        this.b = b;
    }
    public void setK(double k) {
        this.k = k;
    }

    @Override
    public String toString() {
        return "(" + k + ", " + b + ")";
    }
    @Override
    public String toEquation() {
        return String.format("y = %.2fx + %.2f", k, b);
    }
    public boolean isParallelTo(Line other) {
        return Coordinates.doubleEquals(this.k, other.getK()) && !Coordinates.doubleEquals(this.b, other.getB());
    }
    public Point intersectWithLine(Line other){
        if (isParallelTo(other)) {
            return null;
        }
        else {
            return getDot(other);
        }
    }
    private Point getDot(Line other) {
        Point point = new Point();
        point.x = evaluateIntersectPointX(other);
        point.y = evaluateIntersectPointY(point.x);
        return point;
    }
    private double evaluateIntersectPointX(Line other) {
        return (other.getB() - this.b) / (this.k - other.getK());
    }
    private double evaluateIntersectPointY(double x) {
        return x * k + b;
    }

    public double getYFromX(final double x) {
        return k * x + b;
    }
    public Point getPointFromX(final double x) {
        return new Point(x, getYFromX(x));
    }




}
