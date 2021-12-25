class Solution {
    public boolean checkValidString(String s) {
        
        Stack<Integer> stackLeft = new Stack<>(); 
        Stack<Integer> stackStar = new Stack<>(); 
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '*') {
                stackStar.push(i);    
            } else if (c == '(') {
                stackLeft.push(i);
            } else {
                if (stackLeft.size() > 0) {
                    stackLeft.pop();
                } else if (stackStar.size() > 0) {
                    stackStar.pop();
                } else { 
                    return false;  
                }
            }
        }
        /*
        (((***
        ***
        */
        while (!stackStar.isEmpty() && !stackLeft.isEmpty()) {
            if (stackStar.pop() < stackLeft.pop() ){
                return false;
            }
        }
        
        return !(stackLeft.size() > 0);
    }
}