package leetcode.oct2020;

import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        System.out.println((new Solution22().asteroidCollision(new int[]{5,10,-10,-5})).length);
    }
}
class Solution22 {
    public int[] asteroidCollision(int[] asteroids) {
        int len = asteroids.length;
        if(len<=1){
            return asteroids;
        }
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<len;i++){
            if(!stack.isEmpty()){
                int colEle = asteroids[i];
                while(!stack.isEmpty()){
                    int topEle = stack.peek();
                    if(topEle>0 && asteroids[i]<0){
                        stack.pop();
                        if(topEle>Math.abs(asteroids[i])){
                            stack.push(topEle);
                            break;
                        }else if(topEle == Math.abs(asteroids[i])){
                            break;
                        }else if(stack.isEmpty()){
                            stack.push(colEle);
                            break;
                        }
                    }
                    else{
                        stack.push(colEle);
                        break;
                    }
                }
            }else{
                stack.push(asteroids[i]);
            }
        }

        len = stack.size();
        int ans[] = new int[len],i=0;
        while(!stack.isEmpty()){
            ans[len-1-i]=stack.pop();
            ++i;
        }
        return ans;
    }
}