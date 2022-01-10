class Solution {
    
    public int characterReplacement(String s, int k) {   
       int charCount = 0, start = 0;
       int res = 1;
       int count[] = new int[26];
       
       for (int i = 0; i < s.length(); i++) {
            charCount = Math.max(charCount, ++count[s.charAt(i) - 'A']);
            if (i - start + 1 - charCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            res = Math.max(res, i - start + 1);    
        }
        return res;
    }
    
}

/*
CSACKBCNALKNC
BCSKBCCCCCC
ccccccccccccc
L
R 
S
k == 0
count

ABC

ABC

AABABBA





*/