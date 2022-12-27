import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Data> q = new LinkedList<>();
        
        for (int i=0; i<priorities.length; i++) {
            pq.add(priorities[i]);
            q.add(new Data(priorities[i], i));
        }
        
        while(!pq.isEmpty()) {
            var maxNum = pq.peek();
            var data = q.poll();
            
            if (data.priority == maxNum) {
                pq.poll();
                answer++;
                
                if (data.location == location) {
                    break;
                }
            }
            
            q.add(data);
        }
        
        return answer;
    }
}

class Data {
    int priority;
    int location;
    
    public Data(int priority, int location) {
        this.priority = priority;
        this.location = location;
    }
}

