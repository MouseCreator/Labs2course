package Lab1.Collections.Geometry;


public class Coordinates {
    private static final double delta = 0.001;
    public static boolean doubleEquals(double a, double b) {
        return Math.abs(a - b) < delta;
    }

    public static double distance(Point point1, Point point2) {
        return Math.sqrt(Math.pow(point1.x - point2.x, 2) + Math.pow(point1.y - point2.y, 2));
    }
    private static double[] solveQuadraticEquation(double a, double b, double c) {
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

        for (double xCoordinate : xCoordinates) {
            if (Double.isFinite(xCoordinate)) {
                points.add(line.getPointFromX(xCoordinate));
            }
        }
        return points;
    }
    public boolean goesThroughCenter(final Line line, final Circle circle) {
        Point center = circle.getCenter();
        return Coordinates.doubleEquals(center.y, center.x * line.getK() + line.getB());
    }
    public static boolean isTangent(final Line line, final Circle circle) {
        return intersectsLineCircle(line, circle).size() == 1;
    }
    public static boolean isTangent(Circle circle1, Circle circle2) {
        return intersectsCircleCircle(circle1, circle2).size() == 1;
    }
    public boolean goesThrough(final Line line, final Circle circle) {
        return intersectsLineCircle(line, circle).size() == 2;
    }

    public static PointFamily intersectsCircleCircle(final Circle circle1, final Circle circle2) {
        Line line = toLine(circle1, circle2);
        PointFamily intersection = intersectsLineCircle(line, circle1);
        removePointsOutOfCircle(intersection, circle1);
        return intersection;
    }
    private static Line toLine(final Circle circle1, final Circle circle2) {
        double k = (circle2.getCenter().x - circle1.getCenter().x) / (circle1.getCenter().y - circle2.getCenter().y);
        if (Double.isInfinite(k)) {
            k = 0;
        }
        double deltaR = (Math.pow(circle2.getRadius(), 2) - Math.pow(circle1.getRadius(), 2));
        double deltaB = (Math.pow(circle1.getCenter().y, 2) - Math.pow(circle2.getCenter().y, 2));
        double deltaA = (Math.pow(circle1.getCenter().x, 2) - Math.pow(circle2.getCenter().x, 2));

        double b = (deltaR + deltaA + deltaB) / 2 / (circle1.getCenter().y - circle2.getCenter().y);

        return new Line(k, b);

    }
    private static void removePointsOutOfCircle (PointFamily intersection, final Circle circle) {
        for (int i = intersection.size() - 1; i >= 0; i--) {
            if (!circle.contains(intersection.get(i))) {
                intersection.remove(i);
            }
        }
    }
}
