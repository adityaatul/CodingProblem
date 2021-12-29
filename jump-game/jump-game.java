class Solution {
    int dp[];
    public boolean canJump(int[] nums) {
        dp = new int[nums.length + 5];
        for(int i = 0; i< nums.length + 5; i++){
            dp[i] = -1;
        }
        return cj(nums, 0);
    }
    boolean cj(int[] nums, int i) {
        
        
        if (i >= nums.length - 1) {
            return true;
        }
        
        if (dp[i] != -1) {
            return dp[i] == 1;
        }
        
        
        //System.out.println(nums[i] +" "+ i);
        
        boolean ret = false;
        for (int j = 1; j <= nums[i]; j++) { //1,2 - 2
            if (cj(nums, Math.min(i + j, nums.length -1))) {
                ret |= true;
                dp[Math.min(i + j, nums.length -1)] = 1;
                return ret;
            } else{
                dp[Math.min(i + j, nums.length -1)] = 0;
            }
        }
        dp[i] = (ret) ? 1 : 0;
        return ret;
            
    }
}