class Solution {
    final int INF = 99999;
    public int orangesRotting(int[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;
        int X[] = {-1, 0, 0, 1};
        int Y[] = {0, 1, -1, 0};
        int vis[][] = new int[row][col];
        int ans = 0, res = 0;
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) { // vis[i][j] = 0, is 0 here as we this is the starting point.
                    queue.add(new int[]{i, j});       
                } else if (grid[i][j] == 1) { // It is important to have inf on 0s and 1s as we have the isolated case of oranges to handle
                    vis[i][j] = INF;
                }    
            }
        }
        
        while (!queue.isEmpty()) {
            int curr[] = queue.poll();
            int x = curr[0];
            int y = curr[1];
            
            for (int i = 0; i < 4; i++) {
                int dx = x + X[i];
                int dy = y + Y[i];
                if (isValid(dx, dy, row, col, vis)) {
                    queue.add(new int[]{dx, dy});
                    vis[dx][dy] = 1 + vis[x][y];   
                    System.out.println(dx+" "+dy);         
                }
            }
        }
         
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans = Math.max(ans, vis[i][j]);
            }
        }
        
    return (ans == INF) ? -1 : ans;
        
    }
    
    private boolean isValid(int dx, int dy, int row, int col, int[][] vis) {
        return  dx >= 0 && dx < row && dy >= 0 && dy < col && vis[dx][dy] == INF;
    }
}