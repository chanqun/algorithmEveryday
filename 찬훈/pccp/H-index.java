import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int length = citations.length;
        
        Arrays.sort(citations);
        
        for (int i =0; i< length; i++) {
            int h = length - i;
            int now = citations[i];
            
            if(now >= h) {
                answer = h;
                break;
            }
        }
        
        return answer;
    }
}
