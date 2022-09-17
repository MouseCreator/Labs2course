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

    public void a(double value) {
        this.a = value;
    }
    public void b(double value) {
        this.b = value;
    }
    public void c(double value) {
        this.c = value;
    }

    public void set(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public GenLine(double a, double b, double c) {
        set(a, b, c);
    }

    public Point pointFromX(double x) {
        assert b != 0;
        return new Point(x, -(a*x+c)/b);
    }
    public Point pointFromY(double y) {
        assert a != 0;
        return new Point(-(b*y+c)/a, y);
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
