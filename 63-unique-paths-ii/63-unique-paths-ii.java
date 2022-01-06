class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int memo[][] = new int[row + 1][col + 1];
        return uniquePathsWithObstaclesHelper(obstacleGrid, row - 1, col - 1, memo);
    }
    
    int uniquePathsWithObstaclesHelper(int[][] obstacleGrid, int row, int col, int[][] memo) {
        if (row < 0 || col < 0 || obstacleGrid[row][col] == 1) {
            return 0;
        }
        if (row == 0 && col == 0) {
            return obstacleGrid[0][0] == 0 ? 1 : 0;
        }
        if (memo[row][col] != 0) {
            return memo[row][col];
        }
        return memo[row][col] = uniquePathsWithObstaclesHelper(obstacleGrid, row - 1, col, memo) + 
                                uniquePathsWithObstaclesHelper(obstacleGrid, row, col - 1, memo);  
    }
}