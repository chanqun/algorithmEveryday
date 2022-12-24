import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int length = 3 * Math.max(queue1.length, queue2.length);
        int answer = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        
        for (int num: queue1) {
            q1.add(num);
            sum1 += num;
        }
        for (int num: queue2) {
            q2.add(num);
            sum2 += num;
        }
        
        while (sum1 != sum2) {
            if (answer > length) {
                return -1;
            }
            answer++;
            
            if (sum1 > sum2) {
                int temp = q1.poll();
                q2.add(temp);
                
                sum1 -= temp;
                sum2 += temp;
            } else {
                int temp = q2.poll();
                q1.add(temp);
                
                sum2 -= temp;
                sum1 += temp;
            }
        }
        
        return answer;
    }
}
