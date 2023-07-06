import java.util.*;

class Solution {
    int[] grade = {6, 6, 5, 4, 3, 2, 1};

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int correctCount = 0;
        int unKnownCount = 0;
        
        for (int i=0; i<lottos.length; i++) {
            if (lottos[i] == 0) {
                unKnownCount++;
            }
            
            for (int num: win_nums) {
                if (lottos[i] == num) {
                    correctCount++;
                }
            }
        }
        
        answer[0] = grade[unKnownCount + correctCount];
        answer[1] = grade[correctCount];
        
        return answer;
    }
}

