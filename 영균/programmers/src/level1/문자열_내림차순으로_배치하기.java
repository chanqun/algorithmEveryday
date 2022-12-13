package level1;


import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/12917
public class 문자열_내림차순으로_배치하기 {
    class Solution {
        public String solution(String s) {
            StringBuilder answer = new StringBuilder();
            s.chars().sorted().forEach(x -> answer.append((char) x));

            return answer.reverse().toString();
        }
        // 스트림 정렬 보다 이게 훨씬 빠름
        public String solution2(String s) {
            char[] sol = s.toCharArray();
            Arrays.sort(sol);
            return new StringBuilder(new String(sol)).reverse().toString();
        }

        // 노가다?
        public String solution3(String s) {
            StringBuilder answer = new StringBuilder(512);

            for (int i = 0; i < s.length(); ) {
                char c = s.charAt(i);
                for (int j = 0; j < s.length(); j++) {
                    if (c < s.charAt(j)) {
                        c = s.charAt(j);
                    }
                }
                s = s.replaceFirst(String.valueOf(c), "");
                answer.append(c);
                if (s.length() == 0) break;
            }

            return answer.toString();
        }

    }
}
