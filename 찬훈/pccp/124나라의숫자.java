class Solution {
    public String solution(int n) {
        String answer = "";
        
        while(n > 0) {
            String temp = "";
            
            if (n % 3 == 2) {
                temp = "2";
            } else if (n % 3 == 1) {
                temp = "1";
            } else {
                temp = "4";
                n -= 1;
            }
            
            answer = temp + answer;
            
            n /= 3;
        }
        
        return answer;
    }
}

