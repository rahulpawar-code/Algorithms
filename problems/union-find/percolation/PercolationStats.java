// https://coursera.cs.princeton.edu/algs4/assignments/percolation/specification.php
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class PercolationStats {
    private static final double CONFIDENCE_95 = 1.96;

    private final double [] threshold;
    private final int trials;
    private double mu;
    private double sigma;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }
        threshold = new double[trials];
        for (int i = 0; i < threshold.length; ++i) {
            threshold[i] = 0.0;
        }
        mu = 0.0;
        sigma = 0.0;
        this.trials = trials;
        int size = n;

        for (int t = 0; t < trials; ++t) {
            Percolation object = new Percolation(size);
            for (int i = 0; i < (size * size); ++i) {
                // Generate a random row and col
                int row = StdRandom.uniform(1, size + 1);
                int col = StdRandom.uniform(1, size + 1);

                // Open the site
                if (!object.isOpen(row, col)) {
                    object.open(row, col);
                }

                // check percolation
                if (object.percolates()) {
                    break;
                }
            }
            threshold[t] = (1.0 * object.numberOfOpenSites()) / (1.0 * size * size);
        }
    }

    // print stats in desired format
    private void printStats() {
        StdOut.printf("%-25s = %10.10f\n", "mean", mean());
        StdOut.printf("%-25s = %10.10f\n", "stddev", stddev());
        StdOut.printf("%-25s = [%10.10f, %10.10f]\n", "95% confidence interval", confidenceLo(), confidenceHi());
    }

    // sample mean of percolation threshold
    public double mean() {
        mu = StdStats.mean(threshold);
        return mu;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        sigma = StdStats.stddev(threshold);
        return sigma;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mu - (CONFIDENCE_95 * sigma) / Math.sqrt(trials);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mu + (CONFIDENCE_95 * sigma) / Math.sqrt(trials);
    }

    // test client (see below)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);

        // Do t experiments on n by n grid
        PercolationStats stats = new PercolationStats(n, t);
        stats.printStats();
    }
}
