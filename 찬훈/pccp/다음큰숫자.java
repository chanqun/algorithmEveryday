class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int count = Integer.bitCount(n);
        
        while (true) {
            n++;
            
            int count1 = Integer.bitCount(n);
            
            if (count == count1) {
                answer = n;
                break;
            }
        }

        return answer;
    }
}
