import java.util.*;

class Solution {
    public int solution(int n, int m) {
        int answer = 0;
 
        for (int i=n; i<=m; i++) {
            boolean result = isPalindrome(i);

            if (result) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPalindrome(int n) {
        String num = "" + n;
        int length = num.length();

        for (int i=0; i<length / 2; i++) {
            if (num.charAt(i) != num.charAt(length - i - 1)) {
                return false;
            }
        }

        return true;
    }
}

