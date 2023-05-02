import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        var sArray = s.toCharArray();
        Arrays.sort(sArray);
        
        for (int i=sArray.length - 1; i>=0 ; i--) {
            answer += Character.toString(sArray[i]);
        }
        
        return answer;
    }
}
