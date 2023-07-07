class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] bab = {"aya", "ye", "woo", "ma"};
        String[] noBab = {"ayaaya", "yeye", "woowoo", "mama"};
        
        for (int i=0; i<babbling.length; i++) {
            String now = babbling[i];
            
            boolean flag = false;
            
            for (String noWord: noBab) {
                if(now.contains(noWord)) {
                    flag = true;
                    break;
                }
            }
            
            if (flag) {
                continue;
            }
            
            for (String temp: bab) {
                now = now.replace(temp, " ");
            }

            now = now.replace(" ", "");
            
            if (now.equals("")) {
                answer++;
            }
        }
        
        return answer;
    }
}
