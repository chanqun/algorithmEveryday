package pccp;

import java.util.*;
import java.util.stream.Collectors;

public class 외톨이_알파벳 {

    class Solution {
        public String solution(String inputString) {
            HashSet<String> answer = new HashSet<>();
            List<String> list = new ArrayList<>();
            char[] inputStringToArray = inputString.toCharArray();

            String input = String.valueOf(inputStringToArray[0]);

            for (int i = 1; i < inputStringToArray.length; i++) {
                // 앞에 문자와 같지 않다면 map 에 집어 넣는다.
                if (!String.valueOf(inputStringToArray[i]).equals(String.valueOf(inputStringToArray[i - 1]))) {
                    if (list.contains(input)) {
                        answer.add(input);
                    } else {
                        list.add(input);
                    }
                    input = String.valueOf(inputStringToArray[i]);
                }

                // 맨 마지막 경우의 수
                if (i == inputStringToArray.length - 1 && list.contains(input))
                    answer.add(String.valueOf(input.charAt(0)));
            }

            return !answer.stream().sorted().collect(Collectors.joining()).equals("") ? answer.stream().sorted().collect(Collectors.joining()) : "N";
        }
    }
}
