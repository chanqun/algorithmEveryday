package level1;


// https://school.programmers.co.kr/learn/courses/30/lessons/81301
public class 숫자_문자열과_영단어 {
    class Solution {
        public int solution(String s) {
            String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

            for (int i = 0; i < 10; i++) {
                s = s.replace(num[i], Integer.toString(i));
            }

            return Integer.parseInt(s);
        }
    }
}
