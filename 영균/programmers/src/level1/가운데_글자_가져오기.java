package level1;

public class 가운데_글자_가져오기 {
    class Solution {
        public String solution(String s) {

            char[] chars = s.toCharArray();
            int half = (int) Math.ceil(chars.length / 2);
            if (chars.length % 2 == 0) {
                return String.valueOf(chars[half - 1]) + chars[half];
            } else {
                return String.valueOf(chars[half]);
            }
        }

        public String solution2(String s){
            return s.substring((s.length()-1) / 2, s.length()/2 + 1);
        }
    }
}
