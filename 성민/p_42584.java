package stackqueue;

public class p_42584 {
	
	public int[] solution(int[] prices) {
        int[] answer = new int [prices.length];

		for(int i = 0; i < prices.length; i++) {
			for(int j = i+1; j < prices.length; j++) {
				if(prices[i] > prices[j] || j == prices.length-1) {
					answer[i] = j -i;
					break;
				}
			}
		}

		answer[answer.length-1] = 0;

		return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
