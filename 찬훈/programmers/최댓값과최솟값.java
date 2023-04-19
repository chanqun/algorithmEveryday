import java.util.*;

class Solution {
    int maxAnswer = 0;
    int minAnswer = 0;
    
    public String solution(String s) {
        String answer = "";
        
        String[] sList = s.split(" ");
        
        maxAnswer = Integer.parseInt(sList[0]);
        minAnswer = Integer.parseInt(sList[0]);
        
        for (int i=0; i<sList.length; i++) {
            int num = Integer.parseInt(sList[i]);
            
            maxAnswer = Math.max(maxAnswer, num);
            minAnswer = Math.min(minAnswer, num);
        }
            
        answer = minAnswer + " " + maxAnswer;
        
        return answer;
    }
}

