package level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/140108
public class 문자열_나누기 {

    public class Solution {
        public int solution(String s) {
            int answer = 0;
            char[] chars = s.toCharArray();
            answer = divider(answer, chars);
            return answer;
        }

        private int divider(int answer, char[] chars) {
            answer += 1;
            char first = chars[0];
            int i = 0, e = 0;
            for (int index = 0; index < chars.length; index++) {
                if (chars[index] == first) i++;
                else e++;
                if (i == e) {
                    if (index + 1 == chars.length) return answer;
                    else return divider(answer, new String(chars).substring(index + 1).toCharArray());
                }
            }
            return answer;
        }


        // 어차피 한 바퀴 끝까지 돌아야 되므로 자르고 다시 순회할 필요 없이 same 과 different 값만 리셋해 주면 된다.
        public int solution2(String s) {
            char prev = '1';
            int same = 0, different = 0, answer = 0;
            for (char c : s.toCharArray()) {
                if (prev == '1') {
                    prev = c;
                    same++;
                    answer++;
                } else if (prev == c) {
                    same++;
                } else {
                    different++;
                }

                if (same == different) {
                    prev = '1';
                    same = 0;
                    different = 0;
                }
            }

            return answer;
        }

    }
}
