class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        List<List<Integer>> res = new ArrayList<>(row);
        boolean pacific[][] = new boolean[row][col];
        boolean atlantic[][] = new boolean[row][col];
        
        for (int i = 0; i < row; i++) {
            // pacific[i][0] = true;
            // atlantic[i][col - 1] = true;
            checkPath(heights, i, 0, pacific);
            checkPath(heights, i, col - 1, atlantic);
            
        }
        
        for (int j = 0; j < col; j++) {
            // pacific[0][j] = true;
            // atlantic[row - 1][j] = true;
            checkPath(heights, 0, j, pacific);
            checkPath(heights, row - 1, j, atlantic);
        }

        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
               if (pacific[i][j] && atlantic[i][j]) {
                   res.add(List.of(i, j));
               }
            }
        }
        return res;
    }
    
    
    void checkPath(int [][] heights, int i, int j, boolean[][] vis) {
        if (i < 0 || j < 0 || i >= heights.length || j >= heights[0].length || vis[i][j]) {
            return ;
        }
        vis[i][j] = true;
        if (i - 1 >= 0 && heights[i][j] <= heights[i - 1][j]) 
            checkPath(heights, i - 1, j, vis); 

        if (i + 1 < heights.length && heights[i][j] <= heights[i + 1][j])
            checkPath(heights, i + 1, j, vis);
        
        if (j + 1 < heights[0].length && heights[i][j] <= heights[i][j + 1])
            checkPath(heights, i, j + 1, vis);
        
        if (j - 1 >= 0 && heights[i][j] <= heights[i][j - 1]) 
            checkPath(heights, i, j - 1, vis) ;
        
        
    }
}