import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while (!s.equals("1")) {
            String str = "";

            for (char temp: s.toCharArray()) {
                if (temp == '0') {
                    answer[1]++;
                } else {
                    str += "1";
                }
            }
            
            int c = str.length();

            s = Integer.toBinaryString(c);
            answer[0]++;
        }

        return answer;
    }
}
