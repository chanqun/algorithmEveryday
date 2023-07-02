import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        var num = Integer.toString(n, 3);
        var reverseNum = new StringBuffer(num).reverse().toString();
        
        answer = Integer.parseInt(reverseNum, 3);
        
        return answer;
    }
}
