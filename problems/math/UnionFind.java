import java.util.HashMap;

class UnionFind{
    private int[] parent; // parent of i which also represent its current component
    private int count;    // number of components
    private HashMap<Point2D, Integer> map;

    public UnionFind(Point2D[] Point2Ds) {
        if (Point2Ds == null) {
            throw new IllegalArgumentException("array can't be null");
        }

        int n = Point2Ds.length;
        parent = new int[n];
        count = n;
        map = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            parent[i] = i;
            map.put(Point2Ds[i], i);
        }
    }

    /**
     * Merge the two sets containing elements p and q
     */
    public void merge(Point2D p, Point2D q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }

        parent[rootQ] = rootP;
        count--;
    }

    /**
     * Returns if two elements are in same set
     */
    public boolean connected(Point2D p, Point2D q) {
        return find(p) == find(q);
    }

    /**
     * Returns the canonical element of the set containing element
     */
    public int find(Point2D p) {
        int pid = map.get(p);
        while (pid != parent[pid]) {
            parent[pid] = parent[parent[pid]];
            pid = parent[pid];
        }
        return pid;
    }

    /**
     * Returns the number of components.
     */
    public int count() {
        return count;
    }
}
