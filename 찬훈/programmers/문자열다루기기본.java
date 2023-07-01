class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        
        if (s.length() != 4 && s.length() != 6) {
            return false;
        }
        
        char[] charList = s.toCharArray();
        
        for(char c: charList) {
            if (c >= '0' && c <= '9') {
                continue;
            }
            
            answer = false;
            break;
        }
        
        return answer;
    }
}
