package level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/77884

/**
 * 열심히 약수의 개수를 구했지만
 * 사실 약수의 개수가 홀수 인지 짝수인지는 그냥 약수 중에 제곱수가 있으면 홀수이고 없으면 짝수이다.
 */
public class 약수의_개수_더하기 {
    class Solution {
        public int solution(int left, int right) {
            int answer = 0;

            for (int i = left; i <= right; i++) {
                int number = countDivider(i);
                if (number % 2 == 0) {
                    answer += number;
                }else{
                    answer -= number;
                }
            }

            return answer;
        }

        private int countDivider(int number) {
            var count = 0;
            double sqrt = Math.sqrt((double) number);// sqrt(k)는, f(x) = x^2 - k = 0의 근

            for (int i = 1; i <= sqrt; i++) {
                if (number % i == 0) {
                    if (i * i == number) {
                        count++;
                    } else {
                        count += 2;
                    }
                }
            }

            return count;
        }

        public int solution2(int left, int right) {
            int answer = 0;

            for (int i=left;i<=right;i++) {
                //제곱수인 경우 약수의 개수가 홀수
                if (i % Math.sqrt(i) == 0) {
                    answer -= i;
                }
                //제곱수가 아닌 경우 약수의 개수가 짝수
                else {
                    answer += i;
                }
            }

            return answer;
        }
    }
}
