package me.kzv.programmers.level1;

public class 나머지가_1이되는_수_찾기 {
    class Solution {
        public int solution(int n) {
            int answer = 1;

            while (true) {
                if (n % answer == 1) break;
                answer += 1;
            }

            return answer;
        }
    }
}
