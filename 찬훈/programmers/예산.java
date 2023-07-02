import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int money = 0;
        
        Arrays.sort(d);
    
        for (int num: d) {
            money += num;
            
            if(money > budget) {
                break;
            }
            
            answer++;
        }
        
        
        return answer;
    }
}
