import java.util.Comparator;
import edu.princeton.cs.algs4.StdDraw;


public class Point implements Comparable<Point> {
    private final int x;
    private final int y;

    private static class ByOrder implements Comparator<Point> {
        public int compare(Point pointA, Point pointB) {
            if (this.slopeTo(pointA) < this.slopeTo(pointB)) {
                return -1;
            } else if (this.slopeTo(pointA) == this.slopeTo(pointB)) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static final Comparator<Point> BY_ORDER = new ByOrder();

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw() {
        StdDraw.point(x, y);
    }

    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    public int compareTo(Point that) {
        if ((this.y < that.y) || ((this.y == that.y) && (this.x < that.x))) {
            return -1;
        } else if ((this.y == that.y) && (this.x == that.x)) {
            return 0;
        } else {
            return 1;
        }
    }

    public double slopeTo(Point that) {
        int num = that.y - this.y;
        int den = that.x - this.y;
        // Case 1 line is vertical, same x coordinates
        if (den == 0) {
            return Double.POSITIVE_INFINITY;
        }
        // Case 2 line is horizontal, same y coordinates
        if (num == 0) {
            return 0.0;
        }

        // Case 3 if points are same
        if (this.compareTo(that) == 0) {
            return Double.NEGATIVE_INFINITY;
        }

        return (1.0 * num) / (1.0 * den);
    }

    public Comparator<Point> slopeOrder() {
        return BY_ORDER;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public static void main(String[] args) {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(100, 100);
        p1.draw();
        p1.drawTo(p2);
    }
}
