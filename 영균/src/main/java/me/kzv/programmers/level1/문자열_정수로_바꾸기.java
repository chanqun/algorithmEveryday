package me.kzv.programmers.level1;

public class 문자열_정수로_바꾸기 {

    class Solution {
        public int solution(String s) {
            int answer = 0;

            switch (s.substring(0, 1)) {
                case "+":
                    answer = Integer.parseInt(s.substring(1));
                    break;
                default:
                    answer = Integer.parseInt(s);
            }
            return answer;
        }
    }

}

// String.valueOf(s.charAt(0))
