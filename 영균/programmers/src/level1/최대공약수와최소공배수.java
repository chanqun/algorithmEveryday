package level1;
import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/12940
public class 최대공약수와최소공배수 {
/**
 *  유클리드 호제법(최대공약수 구하기) - 2개의 자연수 a, b(a > b)에 대해서 a를 b로 나눈 나머지가 r일 때, a와 b의 최대공약수는 b와 r의 최대공약수와 같다.
 *  큰 수 나누기 작은수를 한 후 다시 작은수 나누기 나머지 를 하여 나머지가 0이 될 때까지 무한반복
 *
 *  최소공배수 구하기 - 두 수 a와 b의 최소공배수는 a와 b의 곱을 a와 b의 최대공약수를 나눈 것과 같다
 */

    class Solution {
        public int[] solution(int n, int m) {
            int a = Math.max(n, m);
            int b = Math.min(n, m);
            int r, gcd, lcm;

            while (b != 0) {
                r = a % b;
                a = b;
                b = r;
            }

            gcd = a;
            lcm = (n * m) / gcd;

            return new int[]{gcd, lcm};
        }

    }
}

// 재귀함수로 구현
class TryHelloWorld {
    public int[] gcdlcm(int a, int b) {
        int[] answer = new int[2];

        answer[0] = gcd(a,b);
        answer[1] = (a*b)/answer[0];
        return answer;
    }

    public static int gcd(int p, int q)
    {
        if (q == 0) return p;
        return gcd(q, p%q);
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        TryHelloWorld c = new TryHelloWorld();
        System.out.println(Arrays.toString(c.gcdlcm(3, 12)));
    }
}