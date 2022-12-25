import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        String temp = Integer.toBinaryString(n);
        
        for (char c: temp.toCharArray()) {
            if (c == '1') {
                ans++;
            }
        }

        return ans;
    }
}
