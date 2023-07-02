import java.util.*;

class Solution {
    public String solution(String s, int n) {
        StringBuffer sb = new StringBuffer();
        
        var sCharList = s.toCharArray();
        
        for (char c: sCharList) {
            if (c >= 'a' && c <= 'z') {
                var changeC = (char)(c + n);
                
                if(!(changeC >= 'a' && changeC <= 'z')) {
                    changeC = (char)(changeC - 26);
                }
                
                sb.append(changeC);
            } else if (c >= 'A' && c <= 'Z') {
                var changeC = (char)(c + n);
                
                if(!(changeC >= 'A' && changeC <= 'Z')) {
                    changeC = (char)(changeC - 26);
                }
                
                sb.append(changeC);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
