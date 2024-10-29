/*You are given a 0-indexed m x n matrix grid consisting of positive integers.

You can start at any cell in the first column of the matrix, and traverse the grid in the following way:

From a cell (row, col), you can move to any of the cells: (row - 1, col + 1), (row, col + 1) and (row + 1, col + 1) such that the value of the cell you move to, should be strictly bigger than the value of the current cell.
Return the maximum number of moves that you can perform.*/


import java.util.*;

class Max {
    public int maxMoves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        
        for (int[] d : dp) {
            Arrays.fill(d, 1);
        }

        for (int j = col - 2; j >= 0; j--) {
            for (int i = 0; i < row; i++) {
                int val = grid[i][j];
                int maxMove = val < grid[i][j + 1] ? dp[i][j + 1] : 0;

                if (i < row - 1) {
                    maxMove = Math.max(maxMove, val < grid[i + 1][j + 1] ? dp[i + 1][j + 1] : 0);
                }

                if (i > 0) {
                    maxMove = Math.max(maxMove, val < grid[i - 1][j + 1] ? dp[i - 1][j + 1] : 0);
                }

                dp[i][j] = 1 + maxMove;
            }
        }

        int ans = 0;
        for (int i = 0; i < row; i++) {
            ans = Math.max(ans, dp[i][0]);
        }

        return ans - 1;
    }
}
