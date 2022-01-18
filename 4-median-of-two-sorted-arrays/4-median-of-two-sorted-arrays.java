class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        if (len1 > len2) return findMedianSortedArrays(nums2, nums1);
        
        int l = 0, r = len1;
        while (l <= r) {
            int p1 = (l + r) / 2;
            int p2 = (len1 + len2 + 1)/2 - p1;
            
            int min1 = (p1 == 0) ? Integer.MIN_VALUE : nums1[p1 - 1]; //Sorted Resultant First array min part
            int min2 = (p1 == len1) ? Integer.MAX_VALUE : nums1[p1]; //Sorted Resultant array min part
            
            int max1 = (p2 == 0) ? Integer.MIN_VALUE : nums2[p2 - 1]; //Sorted Resultant array max part
            int max2 = (p2 == len2) ? Integer.MAX_VALUE : nums2[p2];//Sorted Resultant array max part
            
            if (min1 <= max2 && max1 <= min2) {
                if ((len1 + len2) % 2 == 0) {
                    return (Math.max(min1, max1) + Math.min(min2, max2)) / 2.0;
                } else {
                    return Math.max(min1, max1);
                }
            } else if (min1 > max2) {
                r = p1 - 1;
            } else {
                l = p1 + 1;
            }
        }
        return 0.0;
    } 
}
/*

{1, 3, 8, 9, 15}
{17, 18, 19, 21, 25}



*/