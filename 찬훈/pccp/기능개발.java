import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int length = speeds.length;
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i=0; i<length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            int left = 100 - progress;
            
            int day = left / speed;
            
            if (left>speed && left%speed!=0) {
                day++;
            }
            
            q.add(day);
        }
        
        List<Integer> list = new ArrayList<>();
        
        int count = 0;
        int now = Integer.MAX_VALUE;
        
        while(!q.isEmpty()) {
            int num = q.poll();
            
            if (now >= num) {
                if (now == Integer.MAX_VALUE) {
                    now = num;    
                }
                
                count++;
            } else {
                list.add(count);

                count = 1;
                now = num;
            }
        }
        
        list.add(count);
        
        return list.stream().mapToInt(i->i).toArray();
    }
}
