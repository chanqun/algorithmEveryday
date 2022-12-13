package level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/82612
public class 부족한_금액_구하기 {

    class Solution {
        public long solution(int price, int money, int count) {
            long answer = 0;
            for (int i = 1; i <= count; i++) {
                answer += (long) price * i;
            }

            answer = answer - money;
//            return answer > 0 ? answer : 0;
            return Math.max(answer, 0);
        }

        public long solution2(long price, long money, long count) {
            return Math.max(price * (count * (count + 1) / 2) - money, 0); // 0과 비교하여 큰 값을 반환
        }

        /**
         * 등차수열
         * 첫째 항을 a, 마지막 항을 n, 일반항을 l, 공차를 d
         * n(a+l) / 2
         * 일반 항이 없는 겨우
         * n(2a + (n-1)d) / 2
         *
         * 이 문제의 경우
         * n = count
         * d = 1
         * a = 1
         * count * ( (2 + (count - 1)) / 2) 총 배수를 구하고 price 에 곱하면 됨
         *
         * 등비수열
         * 첫째 항을 a, 마지막 항을 n, 공비를 r
         * 공비가 1보다 작을 경우
         * a(1 - r^n) / 1 - r
         * 공비가 1보다 클 경우
         * a(r^n - 1) / r - 1
         *
         */
    }
}
