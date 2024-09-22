package me.kzv.programmers.level1;

public class 수박수박수박 {
    class Solution {
        public String solution(int n) {
            if (n == 1) return "수";
            String answer = "";

            for (int i = 0; i < Math.floor(n / 2); i++) {
                answer += "수박";
            }
            return n % 2 == 0 ? answer : answer + "수";
        }

        // 반복문 돌면서 하나씩 더하는 것보다 훨씬 빠름
        public String solution2(int n) {
            return new String(new char[n / 2 + 1]).replace("\0", "수박").substring(0, n);
        }
    }

    public static void main(String[] args) {
        char[] chars = new char[1];
        System.out.println(String.valueOf(chars[0]).equals("\0"));
        // 빈 배열값은 \0 인듯??
    }
}
