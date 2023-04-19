import java.util.*;

class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        for (int tan: tangerine) {
            map.put(tan, map.getOrDefault(tan, 0) + 1);
        }
        
        var list = new ArrayList<>(map.entrySet());        
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        
        for (var entry : list) {
            if(k<=0) break;
            answer++;
            k -= entry.getValue();
        }
        
        return answer;
    }
}

