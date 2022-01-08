class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int num: nums) {
            if (!map.containsKey(num)) {
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);
                int count = left + 1 + right;
                
                result = Math.max(result, count);
                map.put(num, count);
                map.put(num - left, count);
                map.put(num + right, count);
            }
        }
        return result;
    }
}
