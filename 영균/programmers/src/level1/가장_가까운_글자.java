package level1;

import java.util.HashMap;

// https://school.programmers.co.kr/learn/courses/30/lessons/142086
public class 가장_가까운_글자 {

    class Solution {
        public int[] solution(String s) {
            char[] chars = s.toCharArray();
            int[] answer = new int[chars.length];
            answer[0] = -1;

            for (int i = 1; i < chars.length; i++) {
                answer[i] = -1;

                for (int j = 0; j < i; j++) {
                    if (String.valueOf(chars[i]).equals(String.valueOf(chars[j]))) {
                        answer[i] = i - j;
                    }
                }
            }

            return answer;
        }

        // map 으로 풀었을 때 더 빠르다.
        public int[] solution2(String s) {
            int[] answer = new int[s.length()];

            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (!map.containsKey(s.charAt(i))) {
                    answer[i] = -1;
                } else {
                    int before = map.get(s.charAt(i));
                    answer[i] = i - before;
                }

                // map 에 계속 최신화해서 값을 기록하므로 반복문으로 게속 전체를 순회하여 돌리는 것보다 훨씬 빠를 수 밖에
                map.put(s.charAt(i), i);
            }
            return answer;
        }
    }


    /**
     * "banana"
     * b a n a n a
     * 기댓값 〉	[-1, -1, -1, 2, 2, 2]
     * 실행 결과 〉	실행한 결괏값 [-1,-1,-1,-1,-1,-1]이 기댓값 [-1,-1,-1,2,2,2]과 다릅니다.
     *
     * f o o b a r
     * 입력값 〉	"foobar"
     * 기댓값 〉	[-1, -1, 1, -1, -1, -1]
     */

}
