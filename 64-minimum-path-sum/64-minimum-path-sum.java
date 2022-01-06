class Solution {
    
    public int minPathSum(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[][] dp = new int[row+1][col+1];
        return minPathSumHelper(grid, row - 1, col - 1, dp);
    }
    
    int minPathSumHelper(int[][] grid, int row, int col, int[][] dp) {
        if (row == 0 && col == 0) {
            return grid[0][0];
        }
        
        if(dp[row][col] != 0) {
            return dp[row][col];
        }
        
        if(row != 0 && col == 0){
            return dp[row][col] = grid[row][col] + minPathSumHelper(grid, row - 1, col, dp);   
        }
        
        if(col != 0 && row == 0){
            return dp[row][col] = grid[row][col] + minPathSumHelper(grid, row, col - 1, dp);   
        }
                                           
        
        return dp[row][col] = grid[row][col] + 
                              Math.min(minPathSumHelper(grid, row - 1, col, dp),
                                       minPathSumHelper(grid, row, col - 1, dp));   
        
    }
}