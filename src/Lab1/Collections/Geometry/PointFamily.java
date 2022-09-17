package Lab1.Collections.Geometry;

import java.util.ArrayList;

/**
 * PointFamily is a structure, that contains 0 or several points
 * Was implemented to avoid using Point arrays and returning null from public methods of other classes
 */
public class PointFamily {
    private ArrayList<Point> points;

    public PointFamily() {
        this.points = new ArrayList<>();
    }
    public PointFamily(Point... points) {
        this.points = new ArrayList<>();
        for (Point p : points)
            this.add(p);
    }
    @Override
    public String toString() {
        return points.toString();
    }
    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (this.getClass() != other.getClass())
            return false;
        if (other instanceof PointFamily family) {
            if (family.size() == this.size()) {
                for (int i = 0; i < family.size(); i++) {
                    if (!this.get(i).equals(family.get(i)))
                        return false;
                }
                return true;
            }
        }
        return false;
    }
    public int size() {
        return points.size();
    }

    public PointFamily add(Point point) {
        points.add(point);
        return this;
    }
    public PointFamily add(double x, double y) {
        points.add(new Point(x, y));
        return this;
    }

    public Point get(int index) {
        return points.get(index);
    }

    public Point remove(int index) {
        return points.remove(index);
    }

    public Point peek() {
        return points.get(0);
    }

    public boolean remove(Point point) {
        return points.remove(point);
    }

    public void sortByX() {
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (points.get(i).x > points.get(j).x) {
                    Point temp = points.get(i);
                    points.set(i, points.get(j));
                    points.set(j, temp);
                }
            }
        }
    }
    public void sortByY() {
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (points.get(i).y > points.get(j).y) {
                    Point temp = points.get(i);
                    points.set(i, points.get(j));
                    points.set(j, temp);
                }
            }
        }
    }

    public void removeDuplicates() {
        for (int i = 0; i < this.size(); i++) {
            for (int j = i + 1; j < this.size(); j++) {
                if (this.get(i).equals(this.get(j))) {
                    this.remove(j);
                }
            }
        }
    }
    public void clear() {
        this.points.clear();
    }
    public void set(int index, Point point) {
        this.points.set(index, point);
    }
}
