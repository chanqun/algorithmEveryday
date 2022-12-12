import java.util.*;

class Solution {
    Set<String> set = new HashSet<>();
    
    public int[] solution(int n, String[] words) {
        int[] answer = {1, 1};
        char beforeChar = words[0].charAt(0);
        
        for (int i=0; i<words.length; i++) {
            String word = words[i];
            
            if (set.contains(word)) {
                return answer;
            }
            set.add(word);
            
            if (beforeChar != word.charAt(0)) {
                return answer;
            }
            beforeChar = word.charAt(word.length() - 1);
            
            answer[0]++;

            if (answer[0] % (n+1) == 0){
                answer[1]++;
                answer[0] = 1;
            }
        }
        
        answer[0] = 0;
        answer[1] = 0;
        
        return answer;
    }
}

