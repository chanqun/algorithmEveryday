import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = new int[] {-1};
        
        var list = new ArrayList<Integer>();
        
        for (int num: arr) {
            if (num % divisor == 0) {
                list.add(num);
            }
        }
        
        Collections.sort(list);
        
        if (!list.isEmpty()) {
            answer = list.stream().mapToInt(Integer::intValue).toArray();
        }
        
        return answer;
    }
}
