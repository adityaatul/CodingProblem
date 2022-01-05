//Template can be used for any questions with sliding window 

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        Map<Character, Integer> mapS = new HashMap<>();
        
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int required = map.size(); //unique element in t, condn to be met for desired window
        int found = 0;
        int ans[] = {-1, 0, 0}; // size, left, right
        
        while (right < s.length()) {
            char c = s.charAt(right);
            mapS.put(c, mapS.getOrDefault(c, 0) + 1);
            
            if (map.containsKey(c) && mapS.get(c).intValue() == map.get(c).intValue()) {
                found++;
            }
            
            while (left <= right && found == required) {
                char cL = s.charAt(left);
                if (ans[0] == -1 || right - left < ans[2] - ans[1]) { 
                    ans[0] = right - left; //size
                    ans[1] = left;
                    ans[2] = right;
                }
                mapS.put(cL, mapS.getOrDefault(cL, 0) - 1);
                if(map.containsKey(cL) && mapS.get(cL).intValue() < map.get(cL).intValue()) {
                    found--;
                }
                ++left;
            }
            ++right;
        }
        
        return (ans[0] == -1) ? "" : s.substring(ans[1], ans[2] + 1);
    }
}

/*
s = "ADOBECODEBANC", t = "ABC"
ADOBEC
DOBECODEBA
ODEBANC -> BANC

*/