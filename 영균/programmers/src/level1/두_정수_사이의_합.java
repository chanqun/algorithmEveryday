package level1;

public class 두_정수_사이의_합 {
    class Solution {
        public long solution(int a, int b) {
            long answer = 0;
            int x, y = 0;

            if (a > b) {
                x = b;
                y = a;
            } else {
                x = a;
                y = b;
            }

            for (int i = x; i <= y; i++) {
                answer += i;
            }
            return answer;
        }
    }

    class Solution2 {
        // 등차 수열의 합
        // -> 항의 개수 * (첫항 + 끝항) / 2

        public long solution(int a, int b) {
            return sumAtoB(Math.min(a, b), Math.max(b, a));
        }

        private long sumAtoB(long a, long b) {
            return (b - a + 1) * (a + b) / 2;
        }
    }
}



