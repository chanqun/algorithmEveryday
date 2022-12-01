package level1;

/**
 * 1-1. 입력된 수가 짝수라면 2로 나눕니다.
 * 1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
 * 2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다.
 * <p>
 * 주의! int 로 커버가 안되서 계산 에러가 나므로 long 으로 변환
 */

public class 콜라츠_추측 {
    class Solution {
        public int solution(long num) {
            if (num == 1) return 1;
            for (int i = 1; i < 501; i++) {
                num = calcNum(num);
                if (num == 1) return i;
            }
            return -1;
        }

        private long calcNum(long num) {
            if (num % 2 == 0) {
                return num / 2;
            } else {
                return num * 3 + 1;
            }
        }

    }
}
