import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i=0; i<score.length; i++) {
            int nowScore = score[i];
            
            if (pq.size() < k) {
                pq.add(nowScore);
                answer[i] = pq.peek();
                continue;
            }
            
            if (pq.peek() < nowScore) {
                pq.poll();
                pq.add(nowScore);
            }
            
            answer[i] = pq.peek();
        }
        
        return answer;
    }
}
