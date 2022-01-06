class Solution {
    public int uniquePaths(int m, int n) {
        int memo[][] = new int[105][105];
        return uniquePathsHelper(m - 1, n - 1, memo); // According to grid since 0 based indexing so -1 for m, n. 
    }
    
    int uniquePathsHelper(int m, int n, int memo[][]) {
        if (m < 0 || n < 0) {
            return 0;
        }
        if (m == 0 && n == 0) {
            return 1;
        }
        if (memo[m][n] > 0) {
            return memo[m][n];
        }
        return  memo[m][n] = uniquePathsHelper(m - 1, n, memo) + uniquePathsHelper(m, n - 1, memo);
    }
}