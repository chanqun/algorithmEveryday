import java.util.*;

class Solution {
    public int solution(int[] menu, int[] order, int k) {
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        int temp = 0;
        for(int i = 0; i < k*order.length; i++){
            if (temp<i) temp = i;
            
            if (!queue.isEmpty() && i == queue.peek()){
                queue.poll();
            }
            
            if (i%k == 0){
                temp += menu[order[i/k]];
                queue.add(temp);
            }
            
            answer = Math.max(answer, queue.size());
        }
        
        return answer;
    }
}

