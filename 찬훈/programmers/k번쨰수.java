import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        
        for(int[] command: commands) {
            int i = command[0] - 1;
            int j = command[1] - 1;
            int k = command[2] - 1;
            
            var list = new ArrayList<Integer>();
            
            for (int index=i; index<=j; index++) {
                list.add(array[index]);
            }
            
            Collections.sort(list);
            answer[idx] = list.get(k);
            idx++;
        }
        
        return answer;
    }
}
