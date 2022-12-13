package level1;

public class 문자열_내_p와_y의_개수 {
    class Solution {
        boolean solution(String s) {
            char[] chars = s.toUpperCase().toCharArray();
            int p = 0, y = 0;

            for (char c : chars) {
                if (String.valueOf(c).equals("P")) p += 1;
                if (String.valueOf(c).equals("Y")) y += 1;
            }

            return p == y;
        }

        // 람다로 풀면
        boolean solution2(String s) {
            s = s.toUpperCase();

            return s.chars().filter( e -> 'P'== e).count() == s.chars().filter( e -> 'Y'== e).count();
        }
    }
}
