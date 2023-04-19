import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String numString = Integer.toString(n, k);
        String[] nums = numString.split("0");
        
        for (String num: nums) {
            if("".equals(num)) {
                continue;
            }

            boolean result = isPrime(Long.parseLong(num));
            
            if (result) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean isPrime(long num) {
        if (num == 1) {
            return false;
        }
        
        for (int i=2; i<=(int)Math.sqrt(num); i++) {
            if (num % i ==0) {
                return false;
            }
        }
        
        return true;
    }
}
