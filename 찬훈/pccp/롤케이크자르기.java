import java.util.*;

class Solution {
    Map<Integer, Integer> map1 = new HashMap<>();
    Map<Integer, Integer> map2 = new HashMap<>();
    
    public int solution(int[] topping) {
        int answer = 0;
        
        for (int top: topping) {
            var num = map1.getOrDefault(top, 0);
            
            map1.put(top, num + 1);
        }
        
        
        
        for (int top: topping) {
            var num1 = map1.getOrDefault(top, 0);
            if (num1 == 1) {
                map1.remove(top);    
            } else {
                map1.put(top, num1 - 1);
            }
            
            var num2 = map2.getOrDefault(top, 0);
            map2.put(top, num2 + 1);
            
            if (map1.keySet().size() == map2.keySet().size()) {
                answer++;
            }
        }

        return answer;
    }
}

