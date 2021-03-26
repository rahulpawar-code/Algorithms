/*
 * Inspiration : https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/Point3D.java.html
 */

import java.util.Comparator;
import java.util.Random;
import java.util.Arrays;

// Immutable class for 3D points
class Point3D implements Comparable<Point3D> {
    final double x;
    final double y;
    final double z;

    public static final Comparator<Point3D> X_ORDER = new XOrder();
    public static final Comparator<Point3D> Y_ORDER = new YOrder();
    public static final Comparator<Point3D> Z_ORDER = new ZOrder();

    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Compare points according to their x-coordinate
    private static class XOrder implements Comparator<Point3D> {
        public int compare(Point3D p, Point3D q) {
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
    private static class YOrder implements Comparator<Point3D> {
        public int compare(Point3D p, Point3D q) {
            if (p.y < q.y) {
                return -1;
            } else if (p.y > q.y) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    // Compare points according to their y-coordinate
    private static class ZOrder implements Comparator<Point3D> {
        public int compare(Point3D p, Point3D q) {
            if (p.z < q.z) {
                return -1;
            } else if (p.z > q.z) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    // Find distance between 2 points
    public double distanceTo(Point3D other) {
        return Math.sqrt((other.x - x) * (other.x - x) +
                (other.y - y) * (other.y - y) +
                (other.z - z) * (other.z - z));
    }

    /**
     * Compares two points by x-coordinate, breaking ties by y-coordinate.
     */
    @Override
        public int compareTo(Point3D that) {
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
            return String.format("(%.2f,%.2f,%.2f)", x, y, z);
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
            Point3D that = (Point3D)other;
            return this.x == that.x && this.y == that.y && this.z == that.z;
        }

    /**
     * Returns an integer hash code for this object.
     */
    @Override
        public int hashCode() {
            int hashX = ((Double) x).hashCode();
            int hashY = ((Double) y).hashCode();
            int hashZ = ((Double) z).hashCode();
            return ((31 * hashX) + hashY) * 31 + hashZ;
        }

    // Return an array of Point3Ds with random coordinates
    public static Point3D[] generateRandomPointArray(int n, double min, double max) {
        if (n <= 0) {
            throw new IllegalArgumentException("Argument n can't be less than 1");
        }

        Point3D[] points = new Point3D[n];
        Random rand = new Random();

        for (int i = 0; i < n; ++i) {
            double x = min + (max - min) * rand.nextDouble();
            double y = min + (max - min) * rand.nextDouble();
            double z = min + (max - min) * rand.nextDouble();
            points[i] = new Point3D(x, y, z);
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
        Point3D[] points = generateRandomPointArray(n, min, max);

        System.out.println("\nSorted by x coordinates");
        Arrays.sort(points, Point3D.X_ORDER);
        Point3D.print(points);

        System.out.println("\nSorted by y coordinates");
        Arrays.sort(points, Point3D.Y_ORDER);
        Point3D.print(points);

        System.out.println("\nSorted by z coordinates");
        Arrays.sort(points, Point3D.Z_ORDER);
        Point3D.print(points);
    }
}
