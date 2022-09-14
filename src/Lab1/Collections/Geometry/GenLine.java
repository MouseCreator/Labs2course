package Lab1.Collections.Geometry;

public class GenLine extends Figure{

    double a;
    double b;
    double c;

    public double a() {
        return a;
    }
    public double b() {
        return b;
    }
    public double c() {
        return c;
    }

    public GenLine(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Point pointFromX(double x) {
        return new Point(x, -(a*x+c)/b);
    }
    @Override
    public String toString() {
        return "(" + a + ", " + b + ", " + c + ")";
    }
    @Override
    public String toEquation() {
        return String.format("%.2fx + %.2fy + %.2fc = 0", a, b, c);
    }
}
