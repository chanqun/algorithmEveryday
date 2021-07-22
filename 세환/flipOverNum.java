class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        String size = String.valueOf(n);
		answer = new int[size.length()];
		int i=0;
		while(true) {
			if(n == 0) break;
			answer[i++] = (int) n%10;
			n /= 10;
		}
        return answer;
    }
}