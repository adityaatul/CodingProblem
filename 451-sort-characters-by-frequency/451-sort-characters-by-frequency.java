class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        List<Character>[] bucket = new List[s.length()+1];
        StringBuilder sb = new StringBuilder();
        
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            char ch = entry.getKey();
            int val = entry.getValue();
            if (bucket[val] == null) {
                bucket[val] = new ArrayList<>();
            }
            bucket[val].add(ch);
        }
        
        for (int i = s.length(); i >= 0; i--) {
            if (bucket[i] != null) {
                for (char c: bucket[i]) {
                    int k = i;
                    while( k-- > 0) sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}