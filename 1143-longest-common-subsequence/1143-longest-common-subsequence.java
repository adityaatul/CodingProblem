class Solution {
    int memo[][];
    public int longestCommonSubsequence(String text1, String text2) {
        
        memo = new int[text1.length() + 1][text2.length() + 1];
        
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) memo[i][j] = -1;
        }
        
        return lcsHelper(0, 0, text1, text2);
    }
    
    int lcsHelper(int i1, int i2, String text1, String text2) {
        if (memo[i1][i2] != -1) {
            return memo[i1][i2];
        }
        
        int ans = 0;
        
        if (text1.charAt(i1) == text2.charAt(i2)) {
            ans = 1 + lcsHelper(i1 + 1, i2 + 1, text1, text2);
        } else {
            ans = Math.max(lcsHelper(i1 + 1, i2, text1, text2), lcsHelper(i1, i2 + 1, text1, text2));
        }
        return memo[i1][i2] = ans;
        
    }
    
}