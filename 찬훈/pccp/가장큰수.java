import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        List<String> list = new ArrayList<>();
        
        for (int number: numbers) {
            list.add("" + number);
        }
        
        Collections.sort(list, (s1, s2) -> (s2+s1).compareTo(s1+s2));
        
        for (String str: list) {
            answer += str;
        }
        
        if (answer.startsWith("0")) {
            return "0";
        }
        
        return answer;
    }
}

