import java.util.*;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    
    public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();
        int idx = 1;
        
        for (char c='A'; c<='Z' ; c++) {
            map.put(String.valueOf(c), idx++);
        }
        
        String w = msg.substring(0, 1);
        
        for (int i=1; i<msg.length(); i++) {
            String c = String.valueOf(msg.charAt(i));
            
            if (map.containsKey(w + c)) {
                w += c;
            } else {
                map.put(w + c, idx++);
                list.add(map.get(w));
                
                w = c;
            }
        }
        
        list.add(map.get(w));
        
        return list.stream().mapToInt(i->i).toArray();
    }
}
