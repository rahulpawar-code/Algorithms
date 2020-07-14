/*
 * Problem : https://www.careercup.com/question?id=5999476452360192
 * Solution : Use divide and conquer approach simiar to closest point algorithm
 */

import java.util.Arrays;

public class GroupPoints2{
    UnionFind components;
    Point2D[] points;

    public GroupPoints2(Point2D[] points) {
        components = new UnionFind(points);
        this.points = points;
    }

    private void printNumGroups() {
        System.out.println("No of groups : " + components.count());
    }

    // Brute force method to group points
    private void bruteForce(Point2D[] points, double k) {
        for (int i = 0; i < points.length; ++i) {
            for (int j = i; j < points.length; ++j) {
                if (points[i].distanceTo(points[j]) <= k) {
                    components.merge(points[i], points[j]);
                }
            }
        }
    }

    // This function will group points within the strip of length of k from mid
    // The complexity of this function is constant. Check the links
    private void groupWithinStrip(Point2D[] points, int size, double k) {
        for (int i = 0; i < size; ++i) {
            for (int j = i + 1; j < size && Math.abs(points[j].y - points[i].y) <= k; ++j) {
                if (points[i].distanceTo(points[j]) <= k) {
                    components.merge(points[i], points[j]);
                }
            }
        }
    }

    // Main functions
    private void groupUtil(Point2D[] px, Point2D[] py, int n, double k) {
        if (n <= 0) {
            return;
        }

        // Use brute force approach for small arrays
        if (n <= 3) {
            bruteForce(px, k);
            return;
        }

        // Get middle point
        int mid = n /2;
        Point2D midPoint = px[mid];

        // Create auxilary arrays to store points on boh side of mid points
        Point2D[] pyl = new Point2D[mid];
        Point2D[] pyr = new Point2D[n - mid];
        int left = 0, right =0;
        for (int i = 0; i < n; ++i) {
            if (i < mid) {
                pyl[left++] = py[i];
            } else {
                pyr[right++] = py[i];
            }
        }

        // Group points on both side of mid point. mid point is already part of pyr
        groupUtil(px, pyl, mid, k);
        groupUtil(px, pyr, mid, k);

        // Find and group points which are at distance of k from vertical line at mid point
        Point2D[] strip = new Point2D[n];
        int j = 0;
        for (int i = 0; i < n; ++i) {
            if (Math.abs(py[i].x - midPoint.x) <= k) {
                strip[j++] = px[i];
            }
        }

        groupWithinStrip(strip, j, k);
    }

    // Entry point to actual functiona
    private void group(double k) {
        if (k < 0) {
            throw new IllegalArgumentException();
        }

        // Create auxilary arrays
        int n = points.length;
        Point2D[] px = new Point2D[n];  // Original array can be reused
        Point2D[] py = new Point2D[n];
        for (int i = 0; i < n; ++i) {
            px[i] = points[i];
            py[i] = points[i];
        }

        // Sort array by x and y coordinates
        Arrays.sort(px, Point2D.X_ORDER);
        Arrays.sort(px, Point2D.Y_ORDER);

        groupUtil(px, py, n, k);
    }

    public static void main(String []args){
        // Generate n random Point
        int n = 100;
        double min = 0.0;
        double max = 100.0;
        Point2D[] points = Point2D.generateRandomPointArray(n, min, max);

        GroupPoints2 group = new GroupPoints2(points);

        // Create groups
        double k = 3.0;
        group.group(k);
        group.printNumGroups();
    }
}
