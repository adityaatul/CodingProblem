package leetcode.sept2020;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public static void main(String[] args) {
        System.out.println(new Solution25().largestNumber(new int[]{3,30,34,5,9}));
    }
}
class Solution25{
    public String largestNumber(int[] nums) {
        if(nums==null || nums.length==0)
            return "";
        String arr[]=new String[nums.length];
        StringBuilder result=new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            arr[i]=String.valueOf(nums[i]);
        }
//        Comparator<String> comp = new Comparator<String>(){
//            @Override
//            public int compare(String str1, String str2){
//                String s1 = str1 + str2;
//                String s2 = str2 + str1;
//                return s2.compareTo(s1); // reverse order here, so we can do append() later
//            }
//        };

        Arrays.sort(arr,(s1, s2) -> (s2+s1).compareTo(s1+s2));
        for (String s:arr) {
            System.out.println(s);
            result.append(s);
        }
        return result.toString().replaceFirst("^0+(?!$)", "");
    }
}