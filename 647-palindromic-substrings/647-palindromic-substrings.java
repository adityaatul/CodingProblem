class Solution {
    public int countSubstrings(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += palindrom(i, i, s);
            result += palindrom(i, i+1, s); //Even length palindrom case!
        }
        return result;
    }
    
    int palindrom(int l, int r, String s) {
        int ans = 0;
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) != s.charAt(r)) {
                break;
            }
            ++ans;
            --l; 
            ++r;
        }
        return ans;
    }
    
}