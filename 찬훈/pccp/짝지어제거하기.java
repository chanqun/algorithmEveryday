import java.util.*;

class Solution{
    public int solution(String s){
        int answer = 0;
        
        Stack<Character> stack = new Stack<>();
        
        for (char c: s.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != c) {
                stack.add(c);
            } else {
                stack.pop();
            }
        }
        
        if (stack.isEmpty()) {
            answer = 1;
        }
        
        return answer;
    }
}
