package leetcode.sept2020;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum3 {
    public static void main(String[] args) {
        System.out.println(new Solution13().combinationSum3(3,9));
    }
}

 class Solution13 {
    Set<List<Integer>> set=new HashSet<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        findSum(1,k,n,list);
        for(List<Integer> temp: set){
            ans.add(temp);
        }
        return ans;
    }

    private void findSum(int start,int size,int target,List<Integer> list) {
        if(target<0 || list.size()>size){
            return;
        }
        if(target==0 && size==list.size()){
            set.add(new ArrayList<>(list));
            return;
        }
        for (int i=start;i<=9;i++){
            list.add(i);
            findSum(i+1,size,target-i,list);
            list.remove(list.size()-1);
        }
    }
}
