class Solution {
    public int numDecodings(String s) {
        Map<Integer, Integer> memo = new HashMap<>();
        return numDecodingsHelper(s, s.length(), 0, memo);
    }
    
    int numDecodingsHelper(String s, int len, int i, Map<Integer, Integer> memo) {
        if (i < len && s.charAt(i) == '0') {
            return 0;
        }
        
        if (i == len || i == len - 1) {
            return 1;
        }
        
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        
        int ans = numDecodingsHelper(s, s.length(), i + 1, memo);
        if (Integer.valueOf(s.substring(i, i + 2)) <= 26) {
            ans += numDecodingsHelper(s, s.length(), i + 2, memo);
        }
        
        memo.put(i, ans);
        
        return ans;
    }
}

/*
111
 K/A
 A/K
A

KA
AAA
AK

11106
AAJF
KJF
*/