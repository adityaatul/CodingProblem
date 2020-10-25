package leetcode.oct2020;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum(new int[]{2,3,5},8));
    }
}

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = candidates.length;
        List<Integer> temp=new ArrayList<>();
        getAllCombination(0,res,temp,candidates,target);
        return res;
    }

    private void getAllCombination(int start, List<List<Integer>> res, List<Integer> temp, int[] candidates, int target) {
        if(target>0){
            for (int i = start; i < candidates.length; i++) {
                temp.add(candidates[i]);
                getAllCombination(i,res,temp,candidates,target-candidates[i]);
                temp.remove(temp.size()-1);
            }
        }else if(target==0){
            res.add(new ArrayList<>(temp));
        }
    }
}