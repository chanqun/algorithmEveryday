class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1L)];
        int idx = 0;
        
        while(left<=right) {
            answer[idx] = (int)(Math.max(left/n, (left++)%n) + (1L));
            idx++;
        }
        
        return answer;
    }
}

