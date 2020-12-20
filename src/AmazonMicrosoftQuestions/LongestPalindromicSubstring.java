package AmazonMicrosoftQuestions;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(new Solution9().longestPalindrome("cbbd"));
    }
}
class Solution9 {
    public String longestPalindrome(String s) {
        int n = s.length();
        String ans = ""+s.charAt(0);
        int dp[][] = new int[n][n];

        //Ans for length 1
        for(int i = 0; i < n; i++){
            dp[i][i] = 1;
        }
        //Ans for length 2
        for(int i = 1; i < n; i++){
            if(s.charAt(i-1) == s.charAt(i)){
                dp[i-1][i] = 1;
                ans = s.substring(i-1, i + 1);
            }
        }
        //Ans for length 3 onwards
        for(int i = 2; i < n; i++){
            for(int j = i, k = 0; j < n ; j++, k++){
                if(s.charAt(j) == s.charAt(k) && dp[k+1][j-1] == 1){
                    dp[k][j] = 1;
                    ans = s.substring(k, j + 1);
                }
            }
        }
        return ans;
    }
}