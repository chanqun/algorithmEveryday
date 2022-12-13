class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        int minNum = Math.min(n, m);
        int commonDiv = 1;

        for (int i=1; i<=minNum; i++) {
            if (n%i == 0 && m%i == 0) {
                commonDiv = i;
            }
        }

        answer[0] = commonDiv;
        answer[1] = (n/commonDiv) * m; 

        return answer;
    }
}
