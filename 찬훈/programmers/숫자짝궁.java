import java.util.*;

class Solution {
    int[] xArray = new int[10];
    int[] yArray = new int[10];
    
    public String solution(String X, String Y) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        for (char c: X.toCharArray()) {
            xArray[Integer.parseInt(c+"")]++;
        }
        for (char c: Y.toCharArray()) {
            yArray[Integer.parseInt(c+"")]++;
        }
        
        boolean isZero = true;
        boolean isEmpty = true;
        for (int i=9; i>=0; i--) {
            int minCount = Math.min(xArray[i], yArray[i]);
            
            for (int j=0; j<minCount; j++) {
                sb.append(i+"");
            }
            
            if (minCount > 0) {
                isEmpty = false;
                
                if (i>0) {
                    isZero = false;    
                }
            }
        }
        
        answer = sb.toString();
        
        if (isZero) {
            answer = "0";
        }
        if (isEmpty) {
            answer = "-1";
        }
        
        return answer;
    }
}
