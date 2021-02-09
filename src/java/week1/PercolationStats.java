/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private static final double CONFIDENCE_95 = 0.96;
    private final int trails;
    private final double[] fractions;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0)
            throw new IllegalArgumentException(
                    "Invalid grid trials length. Length should be greater than or equal to 1");

        this.trails = trials;
        this.fractions = new double[trials];

        for (int i = 0; i < trials; i++) {
            Percolation p = new Percolation(n);
            while (!p.percolates()) {
                int x = StdRandom.uniform(1, n + 1);
                int y = StdRandom.uniform(1, n + 1);
                if (!p.isOpen(x, y))
                    p.open(x, y);
            }
            fractions[i] = p.numberOfOpenSites() * 1.0 / (n * n);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(fractions);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(fractions);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - ((CONFIDENCE_95 * stddev()) / Math.sqrt(trails));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + ((CONFIDENCE_95 * stddev()) / Math.sqrt(trails));
    }

    // test client (see below)
    public static void main(String[] args) {
        if (args.length < 2)
            throw new IllegalArgumentException("2 arguments should be passed");

        int gridSize = Integer.parseInt(args[0]);
        int totalComputations = Integer.parseInt(args[1]);

        PercolationStats ps = new PercolationStats(gridSize, totalComputations);

        System.out.println("mean " + ps.mean());
        System.out.println("stddev " + ps.stddev());
        System.out.println("95% confidence interval = "
                                   + ps.confidenceLo() + ", "
                                   + ps.confidenceHi());

    }
}
