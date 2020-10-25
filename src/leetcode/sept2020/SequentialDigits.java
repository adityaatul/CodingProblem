package leetcode.sept2020;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
    public static void main(String[] args) {
        System.out.println(new Solution20().sequentialDigits(1000,13000));
    }
}
class Solution20{
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        String digit = "123456789";
        int l = String.valueOf(low).length();
        int h = String.valueOf(high).length();
        for (int i = l; i <= h; i++) {
            for (int j = 0; j < 10-i; j++) {
                int val = Integer.parseInt(digit.substring(j,j+i));
                if(val>= low && val<=high){
                    result.add(val);
                }
            }
        }
        return result;
    }
}
