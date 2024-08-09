/** Q 840 . magic-squares-in-grid
 A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.

Given a row x col grid of integers, how many 3 x 3 contiguous magic square subgrids are there?

Note: while a magic square can only contain numbers from 1 to 9, grid may contain numbers up to 15.
  */
class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        // empty grid
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int count = 0;
        
        // iterate through the grid
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                
                // check if current position is a magic square
                if (isMagicSquare(grid, i, j)) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    // helper method to check if a 3x3 grid is a magic square
    private boolean isMagicSquare(int[][] grid, int row, int col) {
        
        // check for duplicates
        Set<Integer> set = new HashSet<>();
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                
                // number cannot be less than 1 or greater than 9
                if (grid[i][j] < 1 || grid[i][j] > 9) {
                    return false;
                }
                
                // number cannot be a duplicate
                if (!set.add(grid[i][j])) {
                    return false;
                }
            }
        }
        
        // check the sums of the rows, cols, and diagonals
        int sum1 = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];
        int sum2 = grid[row + 1][col] + grid[row + 1][col + 1] + grid[row + 1][col + 2];
        int sum3 = grid[row + 2][col] + grid[row + 2][col + 1] + grid[row + 2][col + 2];
        int sum4 = grid[row][col] + grid[row + 1][col] + grid[row + 2][col];
        int sum5 = grid[row][col + 1] + grid[row + 1][col + 1] + grid[row + 2][col + 1];
        int sum6 = grid[row][col + 2] + grid[row + 1][col + 2] + grid[row + 2][col + 2];
        int sum7 = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
        int sum8 = grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col];
        
        return sum1 == sum2 && sum2 == sum3 && sum3 == sum4 && sum4 == sum5 && sum5 == sum6 && sum6 == sum7 && sum7 == sum8;
    }
}
