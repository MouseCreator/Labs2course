package Lab1.Collections.Geometry;

import java.util.Arrays;

public class Coordinates {
    private static double delta = 0.001;
    public static boolean doubleEquals(double a, double b) {
        return Math.abs(a - b) < delta;
    }
    private static double[] solveQuadraticEquation(double a, double b, double c) {
        double disc = getDiscriminant(a, b, c);
        return getRoots(a, b, disc);
    }
    private static double getDiscriminant(double a, double b, double c) {
        return b * b - 4 * a * c;
    }
    private static double[] getRoots(double a, double b, double disc) {
        double result[] = new double[2];
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
    private static double getRoot2(double a, double b, double disc) {
        return (-b + Math.sqrt(disc)) / 2 / a;
    }
    public static PointFamily intersectsLineCircle(Line line, Circle circle) {
        double k = line.getK();
        double b = line.getB();
        double centerX = circle.getCenter().x;
        double centerY = circle.getCenter().y;
        double radius = circle.getRadius();
        double[] solution = solveQuadraticEquation(Math.pow(k, 2) + 1, 2*(k*b-k*centerY-centerX),
                Math.pow((b-centerY),2)-Math.pow(radius,2)+Math.pow(centerX,2));
        PointFamily points = dotsFromXs(solution, line);
        points.removeDuplicates();
        return points;

    }
    private static PointFamily dotsFromXs(final double[] xCoordinates, final Line line) {
        int length = xCoordinates.length;

        PointFamily points = new PointFamily();

        for (int i = 0; i < length; i++) {
            if (Double.isFinite(xCoordinates[i])) {
                points.add(line.getPointFromX(xCoordinates[i]));
            }
        }
        return points;
    }
    public boolean goesThroughCenter(Line line, Circle circle) {
        Point center = circle.getCenter();
        return Coordinates.doubleEquals(center.y, center.x * line.getK() + line.getB());
    }
    public boolean isTangent(Line line, Circle circle) {
        return false;
    }
    public boolean goesThrough(Circle circle) {
        return false;
    }
}
