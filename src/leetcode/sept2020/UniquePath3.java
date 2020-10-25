package leetcode.sept2020;

import java.util.Arrays;
import java.util.List;

public class UniquePath3 {
    public static void main(String[] args) {
        System.out.println(new Solution21().uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,0,2}}));
    }
}
class Solution21{
    int paths=0;
    public int uniquePathsIII(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int zeros=0,sx=0,sy=0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(grid[i][j]==1){
                    sx=i;sy=j;
                }else if(grid[i][j]==0) {
                    ++zeros;
                }
            }
        }
        totalpaths(sx,sy,zeros,grid);
        return paths;
    }
    private void totalpaths(int i,int j,int zeros,int [][]grid){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==-1 || (grid[i][j]==2 && zeros!=0))
            return ;
        if(grid[i][j]==2 && zeros==0)
            paths++;
        if(grid[i][j]==0)
            --zeros;

        int temp = grid[i][j];
        grid[i][j]=-1;

        totalpaths(i,j+1,zeros,grid);
        totalpaths(i+1,j,zeros,grid);
        totalpaths(i,j-1,zeros,grid);
        totalpaths(i-1,j,zeros,grid);

        grid[i][j]=temp;
    }
}
