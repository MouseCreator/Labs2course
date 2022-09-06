package Lab1.Collections.Geometry;

public class Coordinates {
    private static double delta = 0.001;
    public static boolean doubleEquals(double a, double b) {
        return Math.abs(a - b) < delta;
    }
}
