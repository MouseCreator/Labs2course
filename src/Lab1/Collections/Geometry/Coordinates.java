package Lab1.Collections.Geometry;


public abstract class Coordinates {
    private static final double delta = 0.001;
    public static boolean doubleEquals(double a, double b) {
        return Math.abs(a - b) < delta;
    }

    public static double distance(Point point1, Point point2) {
        return Math.sqrt(Math.pow(point1.x - point2.x, 2) + Math.pow(point1.y - point2.y, 2));
    }

    public static PointFamily intersectsLineCircle(Line line, Circle circle) {
        double k = line.getK();
        double b = line.getB();
        double centerX = circle.getCenter().x;
        double centerY = circle.getCenter().y;
        double radius = circle.getRadius();
        double[] solution = CoordinatesMath.solveQuadraticEquation(Math.pow(k, 2) + 1, 2*(k*b-k*centerY-centerX),
                Math.pow((b-centerY),2)-Math.pow(radius,2)+Math.pow(centerX,2));
        PointFamily points = dotsFromXs(solution, line);
        points.removeDuplicates();
        return points;

    }
    private static PointFamily dotsFromXs(final double[] xCoordinates, final Line line) {

        PointFamily points = new PointFamily();

        for (double xCoordinate : xCoordinates) {
            if (Double.isFinite(xCoordinate)) {
                points.add(line.getPointFromX(xCoordinate));
            }
        }
        return points;
    }
    private static PointFamily dotsFromXs(final double[] xCoordinates, final GenLine line) {

        PointFamily points = new PointFamily();

        for (double xCoordinate : xCoordinates) {
            if (Double.isFinite(xCoordinate)) {
                points.add(line.pointFromX(xCoordinate));
            }
        }
        return points;
    }
    private static PointFamily dotsFromYs(final double[] yCoordinates, final GenLine line) {

        PointFamily points = new PointFamily();

        for (double yCoordinate : yCoordinates) {
            if (Double.isFinite(yCoordinate)) {
                points.add(line.pointFromY(yCoordinate));
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

    public static boolean isParallel(GenLine line1, GenLine line2) {
        if (line1.a() == line2.a() && line2.a() == 0) {
            return true;
        }
        if (line1.b() == line2.b() && line2.b() == 0) {
            return true;
        }
        return Coordinates.doubleEquals(line1.a() / line2.a(), line1.b() / line2.b());
    }
    public static PointFamily intersects(GenLine line1, GenLine line2) {

        PointFamily family = new PointFamily();

        if (!isParallel(line1, line2)) {
            double intersectX;
            if (line1.b() == 0) {
                intersectX = -line1.c() / line1.a();
                family.add(line2.pointFromX(intersectX));
            }
            else if (line2.b() == 0) {
                intersectX = -line2.c() / line2.a();
                family.add(line1.pointFromX(intersectX));
            }
            else {
                intersectX = (line1.c() * line2.b() / line1.b() - line2.c()) / (line2.a() - line1.a() * line2.b() / line1.b());
                family.add(line2.pointFromX(intersectX));
            }

        }

        return family;
    }

    public static PointFamily intersects(final GenLine line, final Circle circle) {

        double a = line.a();
        double b = line.b();
        double c = line.c();
        double centerX = circle.getCenter().x;
        double centerY = circle.getCenter().y;
        double radius = circle.getRadius();
        if (b != 0) {
            double x2 = 1 + Math.pow(a / b, 2);
            double x1 = -2 * centerX + 2 * a * centerY / b + 2 * a * c / Math.pow(b, 2);
            double x0 =
                    Math.pow(centerX, 2) + Math.pow(c / b, 2) + 2 * c * centerY / b + Math.pow(centerY, 2) - Math.pow(radius, 2);
            double[] solution = CoordinatesMath.solveQuadraticEquation(x2, x1, x0);
            PointFamily points = dotsFromXs(solution, line);
            points.removeDuplicates();
            return points;
        }
        else {
            double y2 = 1;
            double y1 = -2 * centerY;
            double y0 = Math.pow(centerY, 2) - Math.pow(radius, 2) + Math.pow(centerX + c/a, 2);

            double[] solution = CoordinatesMath.solveQuadraticEquation(y2, y1, y0);
            PointFamily points = dotsFromYs(solution, line);
            points.removeDuplicates();
            return points;
        }
    }
    public static boolean goesThroughCenter(final GenLine line, final Circle circle) {
        return Coordinates.doubleEquals(circle.getCenter().x * line.a() + circle.getCenter().y * line.b() + line.c(), 0.0);
    }

    public static GenLine orthogonalTo(GenLine line, Point goesThrough) {
        return new GenLine(line.b(), -line.a(), -(line.b()*goesThrough.x - line.a() * goesThrough.y));
    }
    public static Vector2D orthogonalTo(Vector2D vector) {
        double cord1 = vector.y;
        double cord2 = -vector.x;
        return new Vector2D(cord1, cord2);
    }

    public static Circle symmetry(GenLine from, Circle of) {
        GenLine orthogonal = orthogonalTo(from, of.getCenter());

        Point middle = intersects(from, orthogonal).peek();

        Point newCenter = symmetry(middle, of.getCenter());

        return new Circle(newCenter, of.getRadius());
    }

    public static Point symmetry(Point center, Point origin) {
        Vector2D delta = new Vector2D(origin, center);
        return CoordinatesMath.move(center, delta);
    }
    public static GenLine symmetry(GenLine center, GenLine origin) {
        if (Coordinates.isParallel(center, origin)) {
            return buildParallelLine(center, origin);
        }
        else {
            return buildReflectedLine(center, origin);
        }
    }
    private static GenLine buildParallelLine(GenLine center, GenLine origin) {
       double delta = center.normalizedLine().c() - origin.normalizedLine().c();
       double c = center.normalizedLine().c() + delta;
       return new GenLine(center.normalizedLine().a(), center.normalizedLine().b(), c);
    }
    private static GenLine buildReflectedLine(GenLine center, GenLine origin) {
       Point intersection = Coordinates.intersects(center, origin).peek();
       Vector2D originVector = origin.getVector();
       Vector2D centerVector = center.getVector();
       Vector2D delta = CoordinatesMath.subtract(centerVector, originVector);
       Vector2D reflection = CoordinatesMath.add(centerVector, delta);
       return new GenLine(reflection, intersection);
    }
}
