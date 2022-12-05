import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<prices.length;i++){
            while(!stack.empty() && prices[stack.peek()] > prices[i]){
                int temp = stack.pop();
                answer[temp] = i - temp;
            }
            stack.push(i);
        }
        
        while(!stack.empty()){
            int temp = stack.pop();
            answer[temp] = (prices.length - 1 ) - temp;
        }
        
        return answer;
    }
}