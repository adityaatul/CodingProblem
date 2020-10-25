package leetcode.oct2020;

import java.util.*;

public class KDiffPairsInArray {
    public static void main(String[] args) {
        System.out.println(new Solution1().findPairs(new int[]{1,3,1,5,4},2));
    }
}
class P{
    int k,v;
    P(int k,int v){
        this.k=k;this.v=v;
    }
}
class Solution1 {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans=0;
        Map<Integer,Integer> hash = new HashMap<>();
        Set<P> set = new HashSet();
        for(int i=0;i<n;i++){
            int val = hash.getOrDefault(nums[i],0);
            hash.put(nums[i],++val);
        }
        for(int i=0;i<n;i++){
            int f=0,b=0;
            hash.put(nums[i],hash.get(nums[i])-1);
            if(i==0){
                f=nums[i]+k;
                if(hash.containsKey(f) && hash.get(f)>0){
                   hash.put(f,hash.get(f)-1);
                   ++ans;
                }
            }else if(i==n-1){
                b = nums[i]-k;
                if(hash.containsKey(b) && hash.get(b)>0){
                    hash.put(f,hash.get(b)-1);
                    ++ans;
                }
            }else{
                f = nums[i]+k;
                b = nums[i]-k;

                if(hash.containsKey(f) && hash.get(f)>0){
                    hash.put(f,hash.get(f)-1);
                    ++ans;
                }

                if(hash.containsKey(b) && hash.get(b)>0){
                    hash.put(f,hash.get(b)-1);
                    ++ans;
                }
            }

        }
        return ans;
    }
}