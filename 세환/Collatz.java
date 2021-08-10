class Solution {
    public int solution(int num) {
       long a = num;
		int answer = 0;
		while(true) {
			if(a == 1) {
				break;
			}
			if(answer >= 500) {
				answer = -1;
				break;
			}
			if(a % 2 == 0) {
				a /= 2;
			}else {
				a = (a * 3) + 1;
			}
            answer++;
		}
        return answer;
    }
}