package AmazonMicrosoftQuestions;

public class PalindromPartitioning2 {
    public static void main(String[] args) {
        System.out.println(new Solution3().minCut("leet"));
    }
}

class Solution3 {
    public int minCut(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int g = 0; g < s.length(); g++) {
            for (int i = 0, j = g; j < dp.length; j++, i++) {
                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        //O(n3) approach
//        int[][] strg = new int[s.length()][s.length()];
//        int ans = 0 ;
//        for (int g = 0; g < s.length(); g++) {
//            for (int i = 0, j = g; j < strg.length; j++, i++) {
//                if (g == 0) { //length of string 1
//                    strg[i][j] = 0;
//                }else if(g == 1){ //length of string 2
//                    if(s.charAt(i) == s.charAt(j)){
//                        strg[i][j] = 0;
//                    }else{
//                        strg[i][j] = 1;
//                    }
//                }else {//length greater than 2
//                    if(dp[i][j]){
//                        strg[i][j] = 0;
//                        continue;
//                    }
//                    int min = Integer.MAX_VALUE;
//                    for (int k = i; k < j; k++) {
//                        //partition at i
//                        int left = strg[i][k];
//                        int right = strg[k+1][j];
//                        if(left + right + 1 < min){
//                            min = left + right + 1;
//                        }
//                    }
//                    strg[i][j] = min;
//                }
//            }
//        }
//        return strg[0][s.length()-1];
        //O(n2) -> Suffix method
        int[] strg = new int[s.length()];
        int minAns = Integer.MAX_VALUE;
        strg[0] = 0;
        for (int j = 1; j < strg.length; j++) {
            if(dp[0][j]){
                strg[j] = 0;
                continue;
            }
            minAns = Integer.MAX_VALUE;
            for (int i = j; i >= 1; i--) {
                //If the suffix is palindrome then only we can check for the rest.
                if (dp[i][j] && strg[i - 1] < minAns) {
                    minAns = strg[i - 1];
                }
            }
            strg[j] = minAns + 1;
        }
        return strg[strg.length - 1];
    }
}