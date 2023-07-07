class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        for (int i=0; i<targets.length; i++) {
            answer[i] = getCount(keymap, targets[i]);
        }
        
        return answer;
    }
    
    private int getCount(String[] keymap, String s) {
        int minCount = 0;
        
        for (char c: s.toCharArray()) {
            int tempMinCount = 100_000;
            
            for(String keymapString: keymap) {
                for (int i=0; i<keymapString.length(); i++) {
                    char keymapC = keymapString.charAt(i);
                    
                    if (c == keymapC) {
                        tempMinCount = Math.min(tempMinCount, i + 1);
                        break;
                    }
                }
            }
            
            minCount += tempMinCount;
        }
        
        if (minCount >= 100_000) {
            minCount = -1;
        }
        
        return minCount;
    }
}
