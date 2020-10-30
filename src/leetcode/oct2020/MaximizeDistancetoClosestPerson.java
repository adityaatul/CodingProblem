package leetcode.oct2020;

import java.util.Arrays;

class MaximizeDistanceToClosestPerson {
    public static void main(String[] args) {
        System.out.println(new Solution2().maxDistToClosest(new int[]{0,1}));
    }
}

class Solution2 {
    public int maxDistToClosest(int[] seats) {
        int ans = 0;
        int n = seats.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int closetL = 0, closetR = n - 1;
        //1,0,0,0,1,0,1
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                closetL = i;
                break;
            }
        }
        for (int i = n-1; i >= 0; i--) {
            if (seats[i] == 1) {
                closetR = i;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                closetL = i;
            }
            left[i] = closetL;
            if (seats[n - 1 - i] == 1) {
                closetR = n - 1 - i;
            }
            right[n - 1 - i] = closetR;
        }
    //        for (int i = 0; i < n; i++) {
    //            System.out.println(i + " : " + left[i]);
    //        }
    //        for (int i = 0; i < n; i++) {
    //            System.out.println(i + " : " + right[i]);
    //        }
        for (int i = 0; i < n; i++) {
            if(seats[i] == 0){
                int l = Math.abs(i - left[i]);
                int r = Math.abs(right[i] - i);
                int dis = Math.min(l, r);
                if(ans < dis){
                    ans = dis;
                }
            }
        }
        return ans;
    }
}