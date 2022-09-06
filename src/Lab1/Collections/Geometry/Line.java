package Lab1.Collections.Geometry;

public class Line extends Figure {
    private double k;
    private double b;

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
        return String.format("y = %. 2fx + % .2f", k, b);
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
        dot.x = evaluateX(other);
        dot.y = evaluateY(dot.x);
        return dot;
    }
    private double evaluateX(Line other) {
        return (other.getB() - this.b) / (this.k - other.getK());
    }
    private double evaluateY(double x) {
        return x * k + b;
    }

    public boolean goesThroughCenter(Circle circle) {
        Dot center = circle.getCenter();
        return Coordinates.doubleEquals(center.y, center.x * k + b);
    }
    public boolean isTangent(Circle circle) {
        return false;
    }
    public boolean goesThrough(Circle circle) {
        return false
    }
}
