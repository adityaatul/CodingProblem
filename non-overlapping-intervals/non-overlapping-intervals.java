class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int end = -Integer.MAX_VALUE;
        int ans = 0;
        
        for (int[] interval: intervals) {
            System.out.println(interval[0] +" "+ interval[1]);   
        }
        
        
        for (int[] interval: intervals) {
            if (end > interval[0]) { // Overlapping
                ++ans;
                end = Math.min(interval[1], end);
            }else{
                end = interval[1];    
            }
            
        }
        
        return ans;
    }
}