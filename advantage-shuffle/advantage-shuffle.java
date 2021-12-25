class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        
        int[] ans = new int[nums1.length];
        int idx = 0, val;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (int num: nums1) {
            val = map.getOrDefault(num, 0); 
            map.put(num, val + 1);
        }
        
        for (int num: nums2) {
            Integer key = map.higherKey(num);
            if (key == null) {
                 key = map.firstKey();
            }
            val = map.get(key);
            ans[idx++] = key;
            if (val == 1) {
                    map.remove(key);
            } else {
                    map.put(key, --val);
            }
        }
        return ans;
    }
}