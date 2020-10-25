package leetcode.sept2020;

public class HouseRobber {
    public static void main(String[] args) {
        System.out.println(new Solution14().rob(new int[]{2,7,9,3,1}));
    }
}
class Solution14 {
    int []dp;
    public int rob(int[] nums) {
        dp = new int[nums.length];
        return robFrom(nums,0);
    }

    private int robFrom(int[] nums, int i) {
        if(i>= nums.length){
            return 0;
        }
        if(dp[i]!=0)
            return dp[i];
        int stealCurrent = nums[i] + robFrom(nums,i+2);
        int skipCurrent = robFrom(nums,i+1);
        return dp[i] = Math.max(stealCurrent,skipCurrent);
    }
}