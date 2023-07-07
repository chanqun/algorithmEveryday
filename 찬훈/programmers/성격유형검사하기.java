import java.util.*;

class Solution {
    int[] choicesContent = {0, 3, 2, 1, 0, -1, -2, -3};
    Map<String, Integer> map = new HashMap<>();
    
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        for (int i=0; i<survey.length; i++) {
            String nowSurvey = survey[i];
            int score = choicesContent[choices[i]];
            
            if (score>0) {
                String temp = String.valueOf(nowSurvey.charAt(0));
                
                int nowScore = map.getOrDefault(temp, 0);
                map.put(temp, nowScore + score);
            } else {
                String temp = String.valueOf(nowSurvey.charAt(1));
                
                int nowScore = map.getOrDefault(temp, 0);
                map.put(temp, nowScore - score);
            }
        }
        
        answer += determineCharacter("R", "T");
        answer += determineCharacter("C", "F");
        answer += determineCharacter("J", "M");
        answer += determineCharacter("A", "N");
        
        return answer;
    }
    
    private String determineCharacter(String a, String b) {
        if (map.getOrDefault(a, 0) < map.getOrDefault(b, 0)) {
            return b;
        }
        
        return a;
    }
}

