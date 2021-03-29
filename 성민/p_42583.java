package stackqueue;

import java.util.*;

public class p_42583 {
	
	public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> bridge = new LinkedList<Integer>();
        
        int currw = 0;
        
        for(int e : truck_weights)
        	q1.add(e);
        
        for(int i = 0; i < bridge_length; i ++) {
        	bridge.add(0);
        }
        
        while(!bridge.isEmpty()) {
        	currw -= bridge.poll();
        	if(!q1.isEmpty()) {
            	if(currw + q1.peek() <= weight) {
            		currw += q1.peek();
            		bridge.add(q1.poll());
            	}
            	else {
            		bridge.add(0);
            	}        		
        	}
        	answer++;
        }
        
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
