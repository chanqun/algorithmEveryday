class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        int bigNum = Math.max(a, b);
        int smallNum = Math.min(a, b);
        
        for (int i=smallNum; i<=bigNum; i++) {
            answer += i;
        }
        
        return answer;
    }
}
