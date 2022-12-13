package level1;

import java.util.Scanner;
import java.util.stream.IntStream;

// https://school.programmers.co.kr/learn/courses/30/lessons/12969
public class 직사각형_별찍기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 스트림으로 풀면

        StringBuilder sb = new StringBuilder();
        IntStream.range(0, a).forEach(s -> sb.append("*")); // 한 줄에 a 개의 별이 있는 문자열 생성
        IntStream.range(0, b).forEach(s -> System.out.println(sb)); // b 줄 만큼 출력
    }
}
