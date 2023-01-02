import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    
    public int solution(int[] elements) {
        int answer = 0;
        
        for(int i=1; i<=elements.length ;i++) {
            int num = 0;
            
            for (int j=0; j<i; j++) {
                num += elements[j];
            }
            
            for (int j=i; j<=elements.length * 2; j++) {
                num -= elements[(j-i+elements.length)%elements.length];
                num += elements[j%elements.length];
                
                set.add(num);
            }
        }

        answer = set.size();
        
        return answer;
    }
}

