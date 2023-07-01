import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int length = arr.length;
        int[] answer = new int[length - 1];
        
        if (arr.length == 1) {
            return new int[] {-1};
        }
        
        int minNum = Integer.MAX_VALUE;
        for(int i=0; i<length; i++) {
            minNum = Math.min(arr[i], minNum);
        }
        
        int index = 0;
        for (int i=0; i<length; i++) {
            if (arr[i] == minNum) {
                continue;
            }
            
            answer[index] = arr[i];
            index++;
        }

        return answer;
    }
}

