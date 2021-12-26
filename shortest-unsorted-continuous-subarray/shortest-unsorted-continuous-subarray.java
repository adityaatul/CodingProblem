class Solution {
    /*
    whenever we come across a value A[i] that is smaller than the current max, we know that the unsorted subarray AT LEAST needs to end here.          Similarly, whenever we come across a value A[n-1-i] that is larger than the current min, we know that the unsorted subarray AT LEAST            needs to start here.
    */
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int end = -2, max = -999999;
        int start = -1, min = 999999;
        
        for (int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
            if (max > nums[i]) {
                end = i;
            } 
            min = Math.min(min, nums[nums.length - 1 - i]);
            if (min < nums[nums.length -1 - i]) {
               start = nums.length -1 - i; 
            }
        }
        
        return end - start + 1;
        
    }
}