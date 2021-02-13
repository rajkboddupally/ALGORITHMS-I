/* *****************************************************************************
@author - Raj Kumar Boddupally
@created date = 02/12/2021
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] grid;
    private final WeightedQuickUnionUF wqf;
    private final int length;
    private int openSites;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n < 1)
            throw new IllegalArgumentException(
                    "Invalid grid length. Length should be greater than or equal to 1");

        grid = new boolean[n][n];
        length = n;
        wqf = new WeightedQuickUnionUF(n * n + 2);
        openSites = 0;

        // initialize the array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = false;
            }
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        int rowIndex = row - 1;
        int colIndex = col - 1;
        validate(row, col);
        if (grid[rowIndex][colIndex])
            return;

        grid[rowIndex][colIndex] = true;
        openSites++;

        // 4 sides  i-1 j  and i+1 j, i j-1 & i j+1
        if (row > 1 && grid[rowIndex - 1][colIndex]) {
            wqf.union(xyTo1D(rowIndex - 1, colIndex), xyTo1D(rowIndex, colIndex));
        }
        if (row < length && grid[rowIndex + 1][colIndex]) {
            wqf.union(xyTo1D(rowIndex + 1, colIndex), xyTo1D(rowIndex, colIndex));
        }
        if (col > 1 && grid[rowIndex][colIndex - 1]) {
            wqf.union(xyTo1D(rowIndex, colIndex - 1), xyTo1D(rowIndex, colIndex));
        }
        if (col < length && grid[rowIndex][colIndex + 1]) {
            wqf.union(xyTo1D(rowIndex, colIndex + 1), xyTo1D(rowIndex, colIndex));
        }

        // connect to virtual top row
        if (row == 1) {
            wqf.union(xyTo1D(rowIndex, colIndex), 0);
        }

        // connect to virtual bottom row
        if (row == length) {
            wqf.union(xyTo1D(rowIndex, colIndex), length * length + 1);
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        validate(row, col);
        return grid[row - 1][col - 1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        validate(row, col);
        if (isOpen(row, col))
            return wqf.find(xyTo1D(row - 1, col - 1)) == wqf.find(0);
        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return wqf.find(0) == wqf.find(length * length + 1);
    }

    // converts 2D to 1D
    private int xyTo1D(int x, int y) {
        return x * length + y + 1;
    }

    // validate row and column index
    private void validate(int row, int col) {
        if (row < 1 || col < 1 || row > length || col > length)
            throw new IllegalArgumentException(
                    "row or column index is out of bounds. row-" + row + " col-" + col);
    }
}
