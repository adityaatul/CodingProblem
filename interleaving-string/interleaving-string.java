class Solution {
   
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int memo[][] = new int[s1.length() + 1][s2.length() + 1];
        
        for(int[] v : memo) {
            Arrays.fill(v, -1);
        }
            
        return isInterleaved(s1, s2, s3, 0, 0, 0, memo);
    }
    
    private boolean isInterleaved(String s1, String s2, String s3, int i1, int i2, int i3, int memo[][]) {
        
        if (i1 == s1.length() && i2 == s2.length()) {
            return true;
        }
        
        if (i3 == s3.length()) {
            return false;
        }
        
        if (memo[i1][i2] != -1) {
            return memo[i1][i2] == 1;
        }
       
        boolean res = false;
        
        if (i1 < s1.length() && s1.charAt(i1) == s3.charAt(i3)) {
            res |= isInterleaved(s1, s2, s3, i1 + 1, i2, i3 + 1, memo);
        }
        
        if (i2 < s2.length() && s2.charAt(i2) == s3.charAt(i3)) {
            res |= isInterleaved(s1, s2, s3, i1, i2 + 1, i3 + 1, memo);
        }
        
        memo[i1][i2] = (res) ? 1 : 0;        
        
            
        return res;
    }
}