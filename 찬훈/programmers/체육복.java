import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        Set<Integer> setLost = new HashSet<>();
        Set<Integer> setReserve = new HashSet<>();
        
        for (int i: lost) {
            setLost.add(i);
        }
        for (int i: reserve) {
            if (setLost.contains(i)) {
                setLost.remove(i);
                continue;
            }
            
            setReserve.add(i);
        }
        
        answer = n - setLost.size();
        
        for (int i: setLost) {
            int beforeNum = i - 1;
            int afterNum = i + 1;
            
            if (setReserve.contains(beforeNum)) {
                setReserve.remove(beforeNum);
                answer++;
            } else if (setReserve.contains(afterNum)) {
                setReserve.remove(afterNum);
                answer++;
            }
        }
        
        return answer;
    }
}
