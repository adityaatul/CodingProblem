class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int hash[] = new int[26];
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        StringBuilder sb;
        
        for (String str : strs) {
            Arrays.fill(hash, 0);
            for (char c : str.toCharArray()) {
                ++hash[c - 'a'];
            }
            sb = new StringBuilder();
            for (int i : hash) {
                sb.append("#");
                sb.append(i);
            }
            if (!map.containsKey(sb.toString())) {
                map.put(sb.toString() , new ArrayList<>());
            }
            map.get(sb.toString()).add(str);
        }
        return new ArrayList<>(map.values()); 
        
    }
//     void findAnagrams(String str, int[] hash, String[] strs, List<List<String>> res, Map<String, Integer> usedStr, int x) {
//         usedStr.put(str, x);
//         List<String> list = new ArrayList<>();
//         list.add(str);
//         int checkHash[];
        
//         for (int i = 0; i < strs.length; i++) {   
//             String s = strs[i];
//             if (usedStr.containsKey(s) && usedStr.get(s) == i) {
//                 continue;
//             }
//             checkHash = new int[26];
//             for (char c : s.toCharArray()) {
//                 ++checkHash[c - 'a'];
//             }
//             if (isSameHash(hash, checkHash)) {
//                 list.add(s);
//                 usedStr.put(s, i);
//             }
//         }
        
//         res.add(new ArrayList<>(list));
        
//     }
//     public boolean isSameHash(int hash[], int checkHash[]) {
//         for (int i = 0; i < 26; i++) {
//             if (hash[i] != checkHash[i]) {
//                 return false;
//             }
//         }
//         return true;
//     }

}
/*
ad
bc
int[26] = 1 0 0 0 1 .... 1
*/
