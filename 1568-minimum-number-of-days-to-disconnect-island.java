/** 1568-minimum-number-of-days-to-disconnect-island 
You are given an m x n binary grid grid where 1 represents land and 0 represents water. An island is a maximal 4-directionally (horizontal or vertical) connected group of 1's.

The grid is said to be connected if we have exactly one island, otherwise is said disconnected.

In one day, we are allowed to change any single land cell (1) into a water cell (0).

Return the minimum number of days to disconnect the grid.
*/
class Solution {
    // Directions array for the 4 possible moves (up, right, down, left).
    private static final int[] DIRS = new int[] { -1, 0, 1, 0, -1 };

    // Instance variables for the grid and its dimensions.
    private int[][] grid;
    private int numRows;
    private int numCols;

    public int minDays(int[][] grid) {
        this.grid = grid;
        numRows = grid.length;
        numCols = grid[0].length;
      
        // If there are not exactly one island, return 0.
        if (countIslands() != 1) {
            return 0;
        }
      
        // Check each cell in the grid.
        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j < numCols; ++j) {
                // If the current cell is land, remove it and count islands.
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (countIslands() != 1) {
                        return 1; // If not exactly one island, return 1
                    }
                    // Revert the grid to its original state.
                    grid[i][j] = 1;
                }
            }
        }
      
        // If removing one land cell does not increase the number of islands,
        // then it must take at least 2 days to break the structure.
        return 2;
    }

    // Utility method to count the number of islands.
    private int countIslands() {
        int count = 0;
        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j < numCols; ++j) {
                // If the cell is land, start DFS and increment island count.
                if (grid[i][j] == 1) {
                    dfs(i, j);
                    ++count;
                }
            }
        }
      
        // Reset modified land cells (marked as 2 during DFS) back to 1.
        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j < numCols; ++j) {
                if (grid[i][j] == 2) {
                    grid[i][j] = 1;
                }
            }
        }
        return count;
    }
  
    // Helper method to perform DFS and mark visited land cells.
    private void dfs(int row, int col) {
        grid[row][col] = 2; // Mark the current cell as visited.
        // Explore all 4 directions from the current cell.
        for (int k = 0; k < 4; ++k) {
            int newRow = row + DIRS[k], newCol = col + DIRS[k + 1];
            // Within the grid bounds and the cell is land.
            if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols && grid[newRow][newCol] == 1) {
                dfs(newRow, newCol); // Continue DFS.
            }
        }
    }
}
