package me.kzv.programmers.level1;

import java.util.ArrayList;

public class x만큼_간격이_있는_n개의_숫자 {
    class Solution {
        public long[] solution(int x, int n) {
            long[] answer = {};
            long[] newArray = new long[n];
            for (int i = 1; i <= n; i++) {
                newArray[i - 1] = (long) x * i;
            }
            answer = newArray;
            return answer;
        }
    }
}
