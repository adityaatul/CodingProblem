package AmazonMicrosoftQuestions;

import java.security.KeyStore;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class MostCommonWord {

    public static void main(String[] args) {
        System.out.println(new Solution().mostCommonWord("Bob , hit ; a ball. atul , the? hit BALL flew far after it was hit.", new String[]{"hit"}));
    }
}
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        if(paragraph.length()==1){
            return paragraph;
        }
        int count =0;
        String ans = null;
        Map<String,Integer> hash = new HashMap();
        String[] para = paragraph.split("[!?',;. ]");
        for (String p:para) {
           if(p.length()>0){
               p = p.toLowerCase();
               int val = hash.getOrDefault(p,0)+1;
               hash.put(p,val);
           }
        }
        for(String ban: banned){
            if(hash.containsKey(ban)){
                hash.remove(ban);
            }
        }
        Iterator iterator = hash.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            int val = (int) entry.getValue();
            if(val>count){
                count = val;
                ans = (String) entry.getKey();
            }
        }
        return ans;
    }
}