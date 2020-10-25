package leetcode.sept2020;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        System.out.println(new Solution29().wordBreak("applepenapple", new ArrayList<>(Arrays.asList("apple", "pen"))));
    }
}
class Solution29 {
    Map<String,Boolean> dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new HashMap<>();
        return isPresent(s,wordDict);
    }

    private boolean isPresent(String s, List<String> wordDict) {
        if(wordDict.contains(s)){
            return true;
        }
        if(dp.containsKey(s)){
            return dp.get(s);
        }
        for (int i = 1; i <= s.length(); i++) {
            String left = s.substring(0,i);
                if(wordDict.contains(left)  && isPresent(s.substring(i),wordDict)){
                    dp.put(s,true);
                return true;
            }
        }
        dp.put(s,false);
        return false;
    }
}