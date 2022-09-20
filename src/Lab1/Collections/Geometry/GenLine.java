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
    public GenLine(Vector2D vector, Point goesThrough) {
        this.a = vector.y;
        this.b = -vector.x;
        this.c = -(goesThrough.x * a + goesThrough.y * b);
    }

    public GenLine(Point point1, Point point2) {
        this(new Vector2D(point1, point2), point2);
    }
    public Point pointFromX(double x) {
        assert b != 0;
        return new Point(x, -(a*x+c)/b);
    }
    public Point pointFromY(double y) {
        assert a != 0;
        return new Point(-(b*y+c)/a, y);
    }


    public Vector2D getVector() {
        return new Vector2D(b, -a);
    }
    @Override
    public String toString() {
        return "(" + a + ", " + b + ", " + c + ")";
    }
    @Override
    public String toEquation() {
        return String.format("%.2fx + %.2fy + %.2fc = 0", a, b, c);
    }
    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (this.getClass() != other.getClass())
            return false;
        GenLine line = (GenLine) other;
        GenLine normalizedLine = line.normalizedLine();
        GenLine thisNormalized = this.normalizedLine();
        return (Coordinates.doubleEquals(normalizedLine.a, thisNormalized.a) &&
                Coordinates.doubleEquals(normalizedLine.b, thisNormalized.b) &&
                Coordinates.doubleEquals(normalizedLine.c,  thisNormalized.c)) ||
                (Coordinates.doubleEquals(normalizedLine.a, -thisNormalized.a) &&
                        Coordinates.doubleEquals(normalizedLine.b, -thisNormalized.b) &&
                        Coordinates.doubleEquals(normalizedLine.c,  -thisNormalized.c));
    }
    public boolean isParallelOX() {
        return this.a == 0;
    }
    public boolean isParallelOY() {
        return this.b == 0;
    }
    protected GenLine normalizedLine() {
        double length = new Vector2D(this).length();
        return new GenLine(a / length, b/length, c/length);
    }
}
