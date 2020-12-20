package AmazonMicrosoftQuestions;

import java.util.Arrays;

public class CoinChange {
}
class Solution5 {

    int[] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        //Arrays.fill(dp, -1);
        //Arrays.sort(coins);
        return minCoinNeeded(coins,amount);
    }
    int minCoinNeeded(int[] coins,int amount){
        if(amount < 0){
            return -1;
        }
        if(amount == 0){
            return 0;
        }
        if(dp[amount] != 0){
            return dp[amount];
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++){
            int temp = minCoinNeeded(coins, amount - coins[i] );
            if(temp != -1){
                ans = Math.min(temp + 1, ans);
            }
        }
        //dp[amount] = -1 , the state is not reachable from here.
        dp[amount] = (ans == Integer.MAX_VALUE) ? -1 : ans;
        return dp[amount];
    }
}