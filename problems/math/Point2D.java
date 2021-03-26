/*
 * Inspiration : https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/Point2D.java.html
 */

import java.util.Comparator;
import java.util.Random;
import java.util.Arrays;

// Immutable class for 2D points
class Point2D implements Comparable<Point2D> {
    final double x;
    final double y;

    public static final Comparator<Point2D> X_ORDER = new XOrder();
    public static final Comparator<Point2D> Y_ORDER = new YOrder();

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Compare points according to their x-coordinate
    private static class XOrder implements Comparator<Point2D> {
        public int compare(Point2D p, Point2D q) {
            if (p.x < q.x) {
                return -1;
            } else if (p.x > q.x) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    // Compare points according to their y-coordinate
    private static class YOrder implements Comparator<Point2D> {
        public int compare(Point2D p, Point2D q) {
            if (p.y < q.y) {
                return -1;
            } else if (p.y > q.y) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    // Find distance between 2 points
    public double distanceTo(Point2D other) {
        return Math.sqrt((other.x - x) * (other.x - x) +
                (other.y - y) * (other.y - y));
    }

    /**
     * Compares two points by x-coordinate, breaking ties by y-coordinate.
     */
    @Override
        public int compareTo(Point2D that) {
            if (this.x < that.x) {
                return -1;
            }
            if (this.x > that.x) {
                return 1;
            }
            if (this.y < that.y) {
                return -1;
            }
            if (this.y > that.y) {
                return 1;
            }
            return 0;
        }

    /**
     * Returns a string representation of this object
     */
    @Override
        public String toString() {
            return String.format("(%.2f,%.2f)", x, y);
        }

    /**
     * Compares this point to the specified point.
     */
    @Override
        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }
            if (other == null || other.getClass() != this.getClass()) {
                return false;
            }
            Point2D that = (Point2D)other;
            return this.x == that.x && this.y == that.y;
        }

    /**
     * Returns an integer hash code for this object.
     */
    @Override
        public int hashCode() {
            int hashX = ((Double) x).hashCode();
            int hashY = ((Double) y).hashCode();
            return 31 * hashX + hashY;
        }

    // Return an array of Point2Ds with random coordinates
    public static Point2D[] generateRandomPointArray(int n, double min, double max) {
        if (n <= 0) {
            throw new IllegalArgumentException("Argument n can't be less than 1");
        }

        Point2D[] points = new Point2D[n];
        Random rand = new Random();

        for (int i = 0; i < n; ++i) {
            double x = min + (max - min) * rand.nextDouble();
            double y = min + (max - min) * rand.nextDouble();
            points[i] = new Point2D(x, y);
        }
        return points;
    }

    // Utility functions to print array
    public static void print(Object[] array) {
        for (Object a : array) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void main(String []args){
        int n = 10;
        double min = 0.0;
        double max = 10.0;
        Point2D[] points = generateRandomPointArray(n, min, max);
        Arrays.sort(points, Point2D.X_ORDER);
        Point2D.print(points);
    }
}
