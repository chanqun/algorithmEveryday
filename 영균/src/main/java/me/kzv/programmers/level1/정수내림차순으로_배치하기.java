package me.kzv.programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class 정수내림차순으로_배치하기 {
    class Solution {
        public long solution(long n) {
            long answer = 0;
            List<Integer> tempList = nList(n);
            tempList.sort((a, b) -> (b - a));
            String tempAnswer = "";

            for (Integer x : tempList) {
                tempAnswer += x;
            }
            answer = Long.parseLong(tempAnswer);

            return answer;
        }

        private List<Integer> nList(long num) {
            ArrayList<Integer> temp = new ArrayList<>();
            while (num >= 1) {
                temp.add((int) (num % 10)); // 정수만 넣어야 한다.
                num /= 10;
            }
            return temp;
        }
    }
}
