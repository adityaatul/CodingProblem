class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] vis = new int[row][col];
        int ans = 0;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && vis[i][j] == 0) {
                    vis[i][j] = 1;
                    countIsland(grid, vis, i, j);
                    ans += 1;
                }
            }
        }
        
        return ans;
    }
    
    void countIsland(char[][] grid, int[][] vis, int idx, int jdx) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{idx, jdx});
        
        int dx[] = {1, 0, -1, 0};
        int dy[] = {0, 1, 0, -1};
        
        while(!queue.isEmpty()) {
            int pos[] = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int x = dx[i] + pos[0];
                int y = dy[i] + pos[1];
                if (isValid(x, y, vis, grid)) {
                    queue.add(new int[]{x, y});
                    vis[x][y] = 1;
                }
            }
        }
    }
    
    boolean isValid(int x, int y, int[][] vis, char[][] grid) {
        return x >= 0 && y >= 0 &&
            x < grid.length && y < grid[0].length &&
            grid[x][y] == '1' && vis[x][y] == 0; 
    }
}