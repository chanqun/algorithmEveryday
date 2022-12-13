package level1;

//https://school.programmers.co.kr/learn/courses/30/lessons/12918
public class 문자열_다루기 {
    class Solution {
        public boolean solution(String s) {
            if (s.length() == 4 || s.length() == 6) {
                try {
                    Integer.parseInt(s);
                } catch (NumberFormatException ex) {
                    return false;
                }
                return true;
            }else return false;
        }

        public boolean solution2(String s) {
            return (s.length() != 4 && s.length() != 6) || (s.split("[0-9]").length > 0) ? false : true;
        }
    }
}
