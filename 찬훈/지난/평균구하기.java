class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        
        for (var num: arr) {
            answer += (double)num;
        }
        
        answer /= arr.length;
        
        return answer;
    }
}
