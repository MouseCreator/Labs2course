package Lab1.Collections.Geometry;

public class CoordinatesMath {

    public static double vectorLength(double x, double y) {
        return Math.sqrt(x * x + y * y);
    }
    public static double[] solveQuadraticEquation(double a, double b, double c) {
        double disc = getDiscriminant(a, b, c);
        return getRoots(a, b, disc);
    }
    private static double getDiscriminant(double a, double b, double c) {
        return b * b - 4 * a * c;
    }
    private static double[] getRoots(double a, double b, double disc) {
        double[] result = new double[2];
        result[0] = getRoot1(a, b, disc);
        result[1] = getRoot2(a, b, disc);
        return result;
    }
    private static double getRoot1(double a, double b, double disc) {
        double sqrtDiscriminant = Math.sqrt(disc);
        if (Double.isNaN(sqrtDiscriminant)) {
            return Double.NaN;
        }
        return (-b - sqrtDiscriminant) / 2 / a;
    }

    public static Vector2D add(final Vector2D a, final Vector2D b) {
        return new Vector2D(a.x + b.x, a.y + b.y);
    }
    public static Point move(final Point origin, final Vector2D delta) {
        return new Point(origin.x + delta.x, origin.y + delta.y);
    }
    public static Vector2D subtract(final Vector2D a, final Vector2D b) {
        return new Vector2D(a.x - b.x, a.y - b.y);
    }
    public static Vector2D opposite(final Vector2D a) {
        return new Vector2D(-a.x, -a.y);
    }
    private static double getRoot2(double a, double b, double disc) {
        return (-b + Math.sqrt(disc)) / 2 / a;
    }
}
