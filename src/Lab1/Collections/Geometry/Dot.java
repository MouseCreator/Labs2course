package Lab1.Collections.Geometry;

public class Dot {
    public double x;
    public double y;

    Dot(double x, double y) {
        this.x = x;
        this.y = y;
    }
    Dot() {
        this. x = 0;
        this. y = 0;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (this.getClass() != other.getClass())
            return false;
        if (other instanceof Dot) {
            Dot d = (Dot) other;
            return Coordinates.doubleEquals(y, d.y) && Coordinates.doubleEquals(y, d.y);
        }
        return false;
    }
}
