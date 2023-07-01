import java.util.*;

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int smallNum = Math.min(n, m);
        int lcm = 1;
        
        for (int i=1; i<= smallNum; i++) {
            if (n%i==0 && m%i==0) {
                lcm = i;
            }
        }
        
        answer[0] = lcm;
        answer[1] = n * m / lcm;
        
        return answer;
    }
}
