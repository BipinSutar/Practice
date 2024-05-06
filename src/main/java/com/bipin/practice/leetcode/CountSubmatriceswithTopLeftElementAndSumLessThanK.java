package com.bipin.practice.leetcode;

public class CountSubmatriceswithTopLeftElementAndSumLessThanK {
    public static void main(String args[]) {
        CountSubmatriceswithTopLeftElementAndSumLessThanK o = new CountSubmatriceswithTopLeftElementAndSumLessThanK();
        System.out.println(o.countSubmatrices(new int[][] { { 7, 2, 9 }, { 1, 5, 0 }, { 2, 6, 6 } }, 20));
    }

    public int countSubmatrices(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i][0] = grid[i][0];
            for (int j = 1; j < cols; j++) {
                matrix[i][j] = matrix[i][j - 1] + grid[i][j];
            }
        }
        printSubmatrix(grid, 0, 0, rows - 1, cols - 1);
        printSubmatrix(matrix, 0, 0, rows - 1, cols - 1);
        int res = 0;
        for (int j = 0; j < cols; j++) {
            int sum = 0;
            for (int i = 0; i < rows; i++) {
                sum += matrix[i][j];
                System.out.print(sum + " ");
                if (sum <= k)
                    res++;
                else
                    break;
            }
            System.out.println("");
        }
        return res;
    }

    public int countSubmatrices1(int[][] grid, int target) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        printSubmatrix(grid, 0, 0, rows - 1, cols - 1);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i > 0)
                    grid[i][j] += grid[i - 1][j];
                if (j > 0)
                    grid[i][j] += grid[i][j - 1];
                if (i > 0 && j > 0)
                    grid[i][j] -= grid[i - 1][j - 1];

                if (grid[i][j] <= target)
                    count++;
                else
                    break;
            }
        }

        printSubmatrix(grid, 0, 0, rows - 1, cols - 1);
        return count;

    }

    public int countSubmatrices2(int[][] grid, int target) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for (int k = 0; k < rows; k++) {
            for (int l = 0; l < cols; l++) {
                printSubmatrix(grid, 0, 0, k, l);
                int sum = sumSubmatrix(grid, 0, 0, k, l);
                if (sum <= target) {
                    count++;
                }
            }
        }

        return count;
    }

    private int sumSubmatrix(int[][] matrix, int startRow, int startCol, int endRow, int endCol) {
        int sum = 0;
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                // System.out.print(matrix[i][j] + " ");
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    // Function to print a submatrix given its start and end indices
    private void printSubmatrix(int[][] matrix, int startRow, int startCol, int endRow, int endCol) {
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void debug(String msg) {
        System.out.println(msg);
    }
}
