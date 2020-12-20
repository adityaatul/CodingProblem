package AmazonMicrosoftQuestions;

public class CoinChange2 {
    public static void main(String[] args) {
        System.out.println(new Solution6().change(5, new int[]{1,2,5}));
    }
}
class Solution6 {
    public int change(int amount, int[] c) {
        if(c.length < 1){
            return 0;
        }
        int[] coins = new int[c.length + 1];
        for(int j = 1; j <= c.length; j++){
            coins[j] = c[j - 1];
        }
        int dp[][] = new int[coins.length][amount + 1];
        numOfWays(amount, coins, dp);
        return dp[coins.length - 1][amount];
    }
    void numOfWays(int amount, int[] coins, int[][] dp){
        dp[0][0] = 1;
        for(int j = 1; j < coins.length; j++){
            dp[j][coins[j]] = 1;
            dp[0][coins[j]] = 1;
            System.out.println(dp[j][coins[j]]);
            for(int i = 1; i <= amount; i++){
                dp[j][i] = dp[j-1][i] + ((coins[j] > i) ? 0 : dp[j][i - coins[j]]);
            }
            System.out.println(coins[j] +" "+dp[j][amount]);
        }
    }
//     int numOfWays(int amount, int[] coins, int[][] dp){
//         if(amount<0){
//             return 0;
//         }
//         if(amount == 0){
//             return 1;
//         }
//         if(dp[amount] != 0){
//             return dp[amount];
//         }
//         int total = 0;
//         for(int coin: coins){
//             int ways = numOfWays(amount - coin, coins, dp);
//             if(ways > 0){
//                 total += ways;
//             }
//         }
//         return dp[amount] = total;
//     }

}
