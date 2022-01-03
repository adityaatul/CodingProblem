class Solution {
    public String longestPalindrome(String s) {
        int len = 0, len1 = 0, len2 = 0, ans = 0, right = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
            len1 = expand(s, i, i);
            len2 = expand(s, i, i + 1);
            len = Math.max(len1, len2); 
            if (ans < len) {
                ans = len;
                right = i + len / 2;
                left = i - (len - 1) / 2; 
            }
        }
        return s.substring(left, right + 1);
    }
    int expand(String s, int L, int R) {
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L-- ;
            R++ ;
        }
        return R - L - 1;
    }
}
/*
baba
abcdedcba
e i = 4
len = 9 / 2 = 4

abcdeedcba
e i = 4
len = 10 / 2 = 5
*/