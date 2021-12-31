class CharCount {
    char c;
    int count;
    CharCount(char c, int count) {
        this.c = c;
        this.count = count;
    }
    void incrementCount() {
        this.count ++ ;
    }
}
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<CharCount> stack = new Stack<>();
        StringBuilder str = new StringBuilder();
        
        for (char c: s.toCharArray()) {
            if (stack.isEmpty()) {
                    stack.push(new CharCount(c, 1));
            } else {
                if (stack.peek().c == c) {
                    stack.peek().incrementCount();
                    
                    if (stack.peek().count % k == 0) {
                      stack.pop();
                    } 
                }else {
                    stack.push(new CharCount(c, 1));
                }
            }
        }
        
        while (!stack.isEmpty()) {
            int count = stack.peek().count;
            while (count-- != 0) {
                str.append(stack.peek().c);    
            }
            stack.pop();
        }
        
        return str.reverse().toString();
    }
}