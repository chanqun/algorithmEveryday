import java.util.*;

class Solution {
    public String solution(String input_string) {
        String answer = "";

        for (int i = 0; i < 26; i++) {
            char temp = (char) (i + 97);

            boolean result = check(input_string, temp);

            if (result) {
                answer += temp;
            }
        }

        if (answer == "") {
            return "N";
        }

        return answer;
    }

    private boolean check(String input_string, char temp) {
        int tempIdx = -1;

        for (int i = 0; i < input_string.length(); i++) {
            if (input_string.charAt(i) == temp) {
                if (tempIdx != -1 && tempIdx + 1 < i) {
                    return true;
                }

                tempIdx = i;
            }
        }

        return false;
    }
}