class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while (n >= a) {
            int share = n / a;
            int remainder = n % a;
            
            answer += share * b;
            n = (share * b) + remainder;
        }
        
        return answer;
    }
}

