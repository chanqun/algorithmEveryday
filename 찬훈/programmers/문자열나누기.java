class Solution {
    public int solution(String s) {
        int answer = 0;
        
        while(s.length() != 0) {
            s = splitS(s);
            answer++;
        }
        
        return answer;
    }
    
    private String splitS(String s) {
        int lCount = 1;
        int rCount = 0;
        int nowChar = s.charAt(0);
        
        for (int i=1; i<s.length(); i++) {
            char temp = s.charAt(i);
            
            if (nowChar == temp) {
                lCount++;
            } else {
                rCount++;
            }
            
            if (lCount == rCount) {
                return s.substring(i + 1);
            }
        }
        
        return "";
    }
}
