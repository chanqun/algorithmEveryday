import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = -1;
        
        long sqrt = (long)Math.sqrt(n);
        
        if (sqrt * sqrt == n) {
            answer = (sqrt + 1) * (sqrt + 1);
        }
        
        return answer;
    }
}
