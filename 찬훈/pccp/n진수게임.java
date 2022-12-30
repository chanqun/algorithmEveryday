class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int num = 0;
        int count = 0;
        String numStr = "";
        
        while (numStr.length()<t*m) {
            numStr += Integer.toString(num++, n);
        }

        for (int i=0; i<numStr.length(); i++) {
            char c = numStr.charAt(i);
            
            if (i%m == p-1) {
                answer += String.valueOf(c);
                count++;
            }
            
            if (count == t) {
                break;
            }
        }

        return answer.toUpperCase();
    }
}

