import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int num: scoville) {
            pq.add(num);
        }
        
        while ((pq.peek() < K) && pq.size() >= 2) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            
            int newNum = num1 + (num2 * 2);
            pq.add(newNum);
            
            answer++;
        }
        
        int num = pq.poll();
        if (num < K) {
            answer = -1;
        }

        return answer;
    }
}

