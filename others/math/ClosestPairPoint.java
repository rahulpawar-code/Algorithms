/*
 * Problem : https://www.geeksforgeeks.org/closest-pair-of-points-onlogn-implementation/
 */

import java.util.Arrays;

public class ClosestPairPoint {

    // Brute force method to calculate min distance between two points
    // This method operates on array element from 0..size
    private static double bruteForce(Point2D[] points, double min) {
        for (int i = 0; i < points.length; ++i) {
            for (int j = i + 1; j < points.length; ++j) {
                min = Math.min(min, points[i].distanceTo(points[j]));
            }
        }
        return min;
    }

    // Find the distance between the closest points of strip of given size. All points
    // are sorted according to y coordinates.
    private static double closestInStrip(Point2D[] points, int size, double min) {
        for (int i = 0; i < size; ++i) {
            for (int j = i + 1; j < size && Math.abs(points[j].y - points[i].y) < min; ++j) {
                min = Math.min(min, points[i].distanceTo(points[j]));
            }
        }
        return min;
    }

    private static double getClosest(Point2D[] px, Point2D[] py, int n) {
        // Use brute force to get minimum distance for very small array
        if (n <= 3) {
            return bruteForce(px, Double.MAX_VALUE);
        }

        // middle point
        int mid = n / 2;
        Point2D midPoint = px[mid];

        // Arrays to store points on repspective sides of middle point
        Point2D[] pyl = new Point2D[mid];
        Point2D[] pyr = new Point2D[n - mid];
        int left = 0;
        int right = 0;
        for (int i = 0; i < n; ++i) {
            if (left < mid) {
                pyl[left++] = px[i];
            } else {
                pyr[right++] = py[i];
            }
        }

        // Find min on left size and right side points. Take min of two
        double minX = getClosest(px, pyl, mid);
        double minY = getClosest(px, pyr, n - mid);
        double min = Math.min(minX, minY);

        // Find points which are within min distance from middle point
        Point2D[] strip = new Point2D[n];
        int j = 0;
        for (int i = 0; i < n; ++i) {
            if (Math.abs(py[i].x - midPoint.x) < min) {
                strip[j++] = px[i];
            }
        }

        // Find and return the closest point in strip
        return closestInStrip(strip, j, min);
    }

    public static double getClosest(Point2D[] points) {
        if (points == null) {
            throw new IllegalArgumentException();
        }

        // Create auxilary arrays to sort points by x and y coordinates
        int n = points.length;
        Point2D[] pointsX = new Point2D[n];
        Point2D[] pointsY = new Point2D[n];
        for (int i = 0; i < points.length; ++i) {
            pointsX[i] = points[i];
            pointsY[i] = points[i];
        }

        Arrays.sort(points, Point2D.X_ORDER);
        Arrays.sort(points, Point2D.Y_ORDER);

        return getClosest(pointsX, pointsY, n);
    }

    public static void main(String[] args) {
        // Get random 2D points
        int n = 23;
        double min = 10;
        double max = 100;
        Point2D[] points = Point2D.generateRandomPointArray(n, min, max);

        double minDistance = ClosestPairPoint.getClosest(points);
        System.out.println(minDistance);
    }
}
