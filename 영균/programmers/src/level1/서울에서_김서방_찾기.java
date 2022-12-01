package level1;

public class 서울에서_김서방_찾기 {
    class Solution {
        public String solution(String[] seoul) {
            int i = 0;
            for (String s : seoul) {
                if (s.equalsIgnoreCase("KIM")) {
                    break;
                }
                i += 1;
            }
            return "김서방은 " + i + "에 있다";
        }
    }
}
