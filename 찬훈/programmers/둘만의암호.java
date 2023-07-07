import java.util.*;

class Solution {
    List<Character> list = new ArrayList<>();
    
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for(int i=0; i<26; i++) {
            list.add((char)(i + 'a'));
        }
        
        for (char c: s.toCharArray()) {
            int newIndex = (c- 'a') % 26;
            
            for (int i=0; i<index;) {
                newIndex = (newIndex + 1) % 26;
                char newChar = (char)(newIndex + 'a');
                
                if (skip.indexOf(newChar) != -1) {
                    continue;
                }
                
                i++;
            }

            answer += String.valueOf((char)(newIndex + 'a'));
        }
        
        return answer;
    }
}
