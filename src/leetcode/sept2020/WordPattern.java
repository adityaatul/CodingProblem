package leetcode.sept2020;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
        System.out.println(new Solution12().wordPattern("aaaa","dog cat cat dog"));
    }
}
class Solution12 {
    public boolean wordPattern(String pattern, String str) {
        String[] splitArr = str.split(" ");
        Map<String,String> hash=new HashMap();
        int p=pattern.length(),len= splitArr.length;
        HashSet<String> hashSet=new HashSet<>();
        if(p==len){
            for(int i=0;i<len;i++){
                String temp = ""+pattern.charAt(i);
                //System.out.println(temp);
                if(hash.containsKey(temp)){
                    if(!hash.get(temp).equals(splitArr[i])) {
                        return false;
                    }
                }else {
//                    Iterator iterator = hash.entrySet().iterator();
//                    while (iterator.hasNext()){
//                        Map.Entry entry = (Map.Entry)iterator.next();
//                        if(entry.getValue().equals(splitArr[i]))
//                            return false;
//                    }
                    if(hashSet.contains(splitArr[i]))
                        return false;
                    hash.put(temp, splitArr[i]);
                }
                hashSet.add(splitArr[i]);
            }
            return true;
        }
        return false;
    }
}