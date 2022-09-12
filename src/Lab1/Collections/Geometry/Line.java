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
    public Dot intersectWithLine(Line other){
        if (isParallelTo(other)) {
            return null;
        }
        else {
            return getDot(other);
        }
    }
    private Dot getDot(Line other) {
        Dot dot = new Dot();
        dot.x = evaluateIntersectPointX(other);
        dot.y = evaluateIntersectPointY(dot.x);
        return dot;
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



    public boolean goesThroughCenter(Circle circle) {
        Dot center = circle.getCenter();
        return Coordinates.doubleEquals(center.y, center.x * k + b);
    }
    public boolean isTangent(Circle circle) {
        return false;
    }
    public boolean goesThrough(Circle circle) {
        return false;
    }
}
