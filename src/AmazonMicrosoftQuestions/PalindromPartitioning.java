package AmazonMicrosoftQuestions;

import java.util.ArrayList;
import java.util.List;

public class PalindromPartitioning {
    public static void main(String[] args) {
        System.out.println((new Solution1()).partition("banana"));
    }
}
class Solution1 {
    public List<List<String>> partition(String s) {
        List<List<String>> results=new ArrayList<>();
        List<String> ans = new ArrayList<>();
        getAllPalindromPartition(results,s, ans);
        return results;
    }

    private void getAllPalindromPartition(List<List<String>> results, String s, List<String> ans) {
        int n = s.length();
        if(n==0){
            results.add(new ArrayList<>(ans));//copy of temp, and not temp as temp is changing in future.
        }
        for (int i = 0; i < n; i++) {
            String prefix = s.substring(0,i+1);//first index inclusive and second is exclusive
            if(isPalindrom(prefix)){
                ans.add(prefix);
                getAllPalindromPartition(results,s.substring(i+1,n),ans); //right partition getting called from.
                ans.remove(ans.size()-1);//backtracking
            }
        }
    }

    private boolean isPalindrom(String prefix) {
        int l=0,r=prefix.length()-1;
        while (l<r){
            if(prefix.charAt(l)!=prefix.charAt(r)){
                return false;
            }
            l++;r--;
        }
        return true;
    }
}