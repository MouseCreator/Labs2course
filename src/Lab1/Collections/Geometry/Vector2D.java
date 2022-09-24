package Lab1.Collections.Geometry;

/**
 * @author MouseCreator
 * Vector 2D is an auxiliary class for lines and points.
 * It is used to determine the direction of a line and to move points from one postion to another.
 */
public class Vector2D {
    public double x;
    public double y;
    public double length() {
        return Math.sqrt(x*x+y*y);
    }

    public boolean isZero() {
        return x==0 && y==0;
    }

    public void normalize() {
        if (isZero()) {
            return;
        }
        this.x = x / length();
        this.y = y / length();
    }
    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Vector2D(Point from, Point to) {
        if (from != null && to != null) {
            this.x = to.x - from.x;
            this.y = to.y - from.y;
        }
    }
    public Vector2D(GenLine line) {
        if (line != null) {
            this.x = -line.b;
            this.y = line.a;
        }
    }

    public Vector2D multiplyBy(double value) {
        this.x *= value;
        this.y *= value;
        return this;
    }
}
