class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int pivot = 0;
        
        if (nums[low] <= nums[high]) {
            return nums[low];
        }
        
        while (low <= high) {
            pivot = low + ((high - low) >> 1);
            
            if (pivot + 1 < nums.length && nums[pivot] > nums[pivot + 1] ) {
                return nums[pivot + 1];
            }
            
            if (nums[pivot] > nums[low]) {
                low = pivot + 1; // Condn checking for pivot + 1 so low can be adjusted for pivot + 1 ;
            } else {
                high = pivot; //If condn checking for pivot - 1 L14 then we can adjust here as well. 
            }
        }
        return -1;
    }
}