import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for (int i=0; i<s.length();i ++) {
            if (isRight(s)) {
                answer++;
            }
            
            s = s.substring(1) + s.substring(0, 1);
        }
        
        return answer;
    }
    
    private boolean isRight(String str) {
        Stack<Character> s = new Stack<>();
        
        for (char c: str.toCharArray()) {
            if (!s.isEmpty()) {
                char before = s.pop();
                if (before=='[' && c==']') {
                    continue;
                }
                
                if (before=='{' && c=='}') {
                    continue;
                }
                
                if (before=='(' && c==')') {
                    continue;
                }
                s.push(before);
            }
            s.push(c);
        }
        
        return s.empty();
    }
}

