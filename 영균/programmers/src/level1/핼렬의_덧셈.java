package level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/12950
public class 핼렬의_덧셈 {
    class Solution {
        public int[][] solution(int[][] arr1, int[][] arr2) {
            int[][] answer = arr1;
            for (int i = 0; i < arr1.length; i++) {
                for (int e = 0; e < arr1[i].length; e++) {
                    answer[i][e] = arr1[i][e] + arr2[i][e];
                }
            }

            return answer;
        }
    }
}
