import java.util.*;

class Solution {
    public int solution(int[] ability, int number) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i=0; i<ability.length; i++) {
            pq.add(ability[i]);
        }
        
        for (int i=0; i<number; i++) {
            int a = pq.poll();
            int b = pq.poll();
            
            pq.add(a+b);
            pq.add(a+b);
        }
        
        while(!pq.isEmpty()) {
            int temp = pq.poll();

            answer += temp;
        }
        
        return answer;
    }
}
