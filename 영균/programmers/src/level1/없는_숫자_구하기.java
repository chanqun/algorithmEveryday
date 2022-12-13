package level1;

public class 없는_숫자_구하기 {
    class Solution {
        public int solution(int[] numbers) {
            int answer = sum(0, 9); // 0 ~ 9 총합 45
            for (int number : numbers) {
                answer -= number;
            }
            return answer;
        }

        private int sum(int a, int b) {
            return (b - a + 1) * (a + b) / 2;
        }
    }
}
