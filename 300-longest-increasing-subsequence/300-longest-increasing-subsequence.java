class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for(int i = 1; i < nums.length; i++) {
            for (int k = 0; k < i; k++) {
                if (nums[i] > nums[k]) {
                    dp[i] = Math.max(dp[i], dp[k] + 1);
                    res = Math.max(res, dp[i]);
                }
            }
        }
        return res;
    }
}



/*

10 3 .... . ...
3

*/