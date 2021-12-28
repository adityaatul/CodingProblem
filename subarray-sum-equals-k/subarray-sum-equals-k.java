class Solution {
    public int subarraySum(int[] nums, int k) {    
        Map<Integer, Integer> map = new HashMap<>();
        int tempSum = 0, ans = 0;
        map.put(tempSum, 1);
        for(int num: nums) {
            tempSum += num;
            if (map.containsKey(tempSum - k)) {
                ans += map.get(tempSum - k);
            }
            map.put(tempSum, map.getOrDefault(tempSum, 0) + 1);
        }
        return ans;
    }
}