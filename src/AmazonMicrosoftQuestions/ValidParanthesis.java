package AmazonMicrosoftQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class ValidParanthesis {
    public static void main(String[] args) {
        System.out.println(new Solution7().isValid("()[]{}"));
    }
}
class Solution7 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char top = s.charAt(i);
            if(s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}'){
                if(!stack.isEmpty()){
                    char c = stack.pop();
                    switch(c){
                        case '(': {
                            if(top != ')'){
                                return false;
                            }

                            break;
                        } case '{' : {
                            if(top != '}'){
                                return false;
                            }
                            break;
                        } case '[' : {
                            if(top != ']'){
                                return false;
                            }
                            break;
                        }
                    }
                }else{
                    return false;
                }
            }else{
                stack.push(top);
            }
        }
        return stack.isEmpty();
    }
}