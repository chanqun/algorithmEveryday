import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        var map = new HashMap<String, Integer>();
        
        for (int i=0; i< name.length; i++) {
            String tempName = name[i];
            int tempYearning = yearning[i];
            
            map.put(tempName, tempYearning);
        }
        
        for (int i=0; i< photo.length; i++) {
            var tempPhoto = photo[i];
            
            for (String tempName: tempPhoto) {
                answer[i] += map.getOrDefault(tempName, 0);
            }
        }
        
        return answer;
    }
}
