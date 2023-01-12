import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        List<Integer> list = new ArrayList<>();

        int temp = -1;

        for (int i=0; i<arr.length; i++) {
            int num = arr[i];

            if (num != temp) {
                temp = num;
                list.add(num);
            }
        }

        answer = new int[list.size()];

        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
