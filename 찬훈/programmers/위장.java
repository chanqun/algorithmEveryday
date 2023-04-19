import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, List<String>> map = new HashMap<>();
        
        for (int i=0; i<clothes.length; i++) {
            String type = clothes[i][1];
            String cloth = clothes[i][0];
            
            if (!map.containsKey(type)) {
                map.put(type, new ArrayList<>());
            }
            
            map.get(type).add(cloth);
        }
        
        for (String type: map.keySet()) {
            var list = map.get(type);
            
            answer *= (list.size()+1);
        }
        
        answer--;
        
        return answer;
    }
}
