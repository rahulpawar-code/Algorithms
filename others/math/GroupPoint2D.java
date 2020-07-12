/*
 * Problem : https://www.careercup.com/question?id=5999476452360192
 */

public class GroupPoint2D{
    UnionFind components;
    Point2D[] points;

    public GroupPoint2D(Point2D[] points) {
        components = new UnionFind(points);
        this.points = points;
    }

   private void printNumGroups() {
        System.out.println("No of groups : " + components.count());
    }

    // Brute force algorithm to group points which are at k
    private void group(double k) {
        if (k < 0) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < points.length; ++i) {
            for (int j = i; j < points.length; ++j) {
                // If distance to other point is less than k, merge the two sets
                if (points[i].distanceTo(points[j]) <= k) {
                    components.merge(points[i], points[j]);
                }
            }
        }
    }

    public static void main(String []args){
        // Generate n random Point
        int n = 100;
        double min = 0.0;
        double max = 100.0;
        Point2D[] points = Point2D.generateRandomPointArray(n, min, max);

        GroupPoint2D group = new GroupPoint2D(points);

        // Create groups
        double k = 10.0;
        group.group(k);
        group.printNumGroups();
    }
}
