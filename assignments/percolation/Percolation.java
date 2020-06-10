import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdOut;

public class Percolation {
    private final WeightedQuickUnionUF set;
    private final int n;
    private boolean[][] state;
    private int openSites;

    private final int top;
    private final int bottom;

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.n = n;
        state = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                state[i][j] = false;
            }
        }

        set = new WeightedQuickUnionUF(n * n + 2);
        openSites = 0;
        top = 0;
        bottom = n * n + 1;
    }

    private int getSerialIndex(int row, int col) {
        return (row - 1) * n + col;
    }

    private boolean isValid(int row, int col) {
        return row >= 1 && col >= 1 && row <= n && col <= n;
    }

    public void open(int row, int col) {
        if (row <= 0 || row > n || col <= 0 || col > n) {
            throw new IllegalArgumentException();
        }

        if (!state[row - 1][col - 1]) {
            state[row - 1][col - 1] = true;
            openSites++;
        }

        if (row == 1) {
            set.union(top, getSerialIndex(row, col));
        }

        if (row == n) {
            set.union(bottom, getSerialIndex(row, col));
        }

        int nextR = row - 1;
        int nextC = col;
        if (isValid(nextR, nextC) && isOpen(nextR, nextC)) {
            set.union(getSerialIndex(row, col), getSerialIndex(nextR, nextC));
        }

        nextR = row + 1;
        nextC = col;
        if (isValid(nextR, nextC) && isOpen(nextR, nextC)) {
            set.union(getSerialIndex(row, col), getSerialIndex(nextR, nextC));
        }

        nextR = row;
        nextC = col + 1;
        if (isValid(nextR, nextC) && isOpen(nextR, nextC)) {
            set.union(getSerialIndex(row, col), getSerialIndex(nextR, nextC));
        }

        nextR = row;
        nextC = col - 1;
        if (isValid(nextR, nextC) && isOpen(nextR, nextC)) {
            set.union(getSerialIndex(row, col), getSerialIndex(nextR, nextC));
        }
    }

    public boolean isOpen(int row, int col) {
        if (row <= 0 || row > n || col <= 0 || col > n) {
            throw new IllegalArgumentException();
        }
        return state[row - 1][col - 1];
    }

    public boolean isFull(int row, int col) {
        if (row <= 0 || row > n || col <= 0 || col > n) {
            throw new IllegalArgumentException();
        }

        return isOpen(row, col) &&
            (set.find(getSerialIndex(row, col)) == set.find(top));
    }

    public int numberOfOpenSites() {
        return openSites;
    }

    public boolean percolates() {
        if (n == 1) {
            return state[0][0];
        }
        return set.find(top) == set.find(bottom);
    }

    public static void main(String[] args) {
        int n = 4;
        Percolation obj = new Percolation(n);
        StdOut.println(obj.numberOfOpenSites() + " " + obj.percolates());
        obj.open(1, 3);
        StdOut.println("isFull : " +  obj.isFull(1, 3));
        StdOut.println("isFull : " +  obj.isFull(4, 3));
        StdOut.println(obj.numberOfOpenSites() + " " + obj.percolates());
        obj.open(2, 3);
        StdOut.println(obj.numberOfOpenSites() + " " + obj.percolates());
        obj.open(2, 4);
        StdOut.println(obj.numberOfOpenSites() + " " + obj.percolates());
        obj.open(3, 4);
        obj.open(4, 4);
        StdOut.println(obj.numberOfOpenSites() + " " + obj.percolates());

        StdOut.println("===========");
        n = 2;
        obj = new Percolation(n);
        obj.open(1, 1);
        obj.open(2, 2);
        StdOut.println(obj.numberOfOpenSites() + " " + obj.percolates());
        StdOut.println("===========");
        n  = 1;
        obj = new Percolation(n);
        StdOut.println(obj.numberOfOpenSites() + " " + obj.percolates());
        obj.open(1, 1);
        StdOut.println(obj.numberOfOpenSites() + " " + obj.percolates());
    }
}
