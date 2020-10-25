package HackerRank.DP;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxArraySumNonAdjacentElements {
    static int dp[];
    static int ans=0;
    public static void main(String[] args) {
        System.out.println(maxSubsetSum(new int[]{ -8, -3, -2, -2, -4}));
    }
//    static int maxSubsetSum(int[] arr) {
//        dp = new int[100005];
//        Map<Integer,Integer> map = new HashMap<>();
//        dp[0]=Math.max(0,arr[0]);
//        if(arr.length==1)
//            return dp[0];
//        dp[1]=Math.max(0,arr[1]);
//        if(arr.length==2)
//            return Math.max(dp[0],dp[1]);
//        dp[2]=Math.max(arr[2],Math.max(arr[2]+arr[0],arr[1]));
//        for(int i=2;i<arr.length;i++)
//        {
//            dp[i]=Math.max(dp[i-2],Math.max(dp[i-1],dp[i-2]+arr[i]));
//        }
//        int n=arr.length;
//        return Math.max(dp[n-1],dp[n-2]);
//    }

//
    static private Map<Integer, Integer> map;
    static int maxSubsetSum(int[] arr) {
        map = new HashMap<>();
        int ans=0;
        if(arr.length>0){
            ans = (arr[0]>0)?arr[0]:0;
        }
        ans =  Math.max(ans,maxSumAdjacent(arr,0));
//        for (Map.Entry<Integer,Integer> e:map.entrySet()) {
//            int v = e.getValue();
//            ans = Math.max(ans,v);
//        }
        return ans;
    }

    private static int maxSumAdjacent(int[] arr, int i) {
        if(i>= arr.length)
            return 0;
        if(map.containsKey(i)){
            return map.get(i);
        }
        int takeCurr  = arr[i] + maxSumAdjacent(arr,i+2);
        int skipCurr  = maxSumAdjacent(arr,i+1);
        int ansI = Math.max(takeCurr,skipCurr);
        map.put(i,ansI);
        return ansI;
    }


}

