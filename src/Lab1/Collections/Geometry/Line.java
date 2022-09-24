package Lab1.Collections.Geometry;

/**
 * Line is a geometric object, representing y = kx + b equation. From definition, it cannot be parallel to X axis.
 * It may be used for simple geometric calculations. For more complex calculations consider using GenLine class instead.
 */
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

    public GenLine toGenLine() {
        return new GenLine(k, -1, b);
    }

    public double getYFromX(final double x) {
        return k * x + b;
    }
    public Point getPointFromX(final double x) {
        return new Point(x, getYFromX(x));
    }





}
