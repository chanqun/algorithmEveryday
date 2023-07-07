import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int count1 = 0;
        int count2 = 0;
        
        for (String word: goal) {
            int tempIdx1 = getIndexOfWord(cards1, word);
            int tempIdx2 = getIndexOfWord(cards2, word);
            
            if (tempIdx1 != -1) {
                if (count1 != tempIdx1) {
                    answer = "No";
                    break;
                }
                count1++;
            } else if (tempIdx2 != -1) {
                if (count2 != tempIdx2) {
                    answer = "No";
                    break;
                }
                count2++;
            } else {
                answer = "No";
                break;
            }
        }

        return answer;
    }
    
    private int getIndexOfWord(String[] cards, String word) {
        int index = -1;
        
        for (int i=0; i<cards.length; i++) {
            if(cards[i].equals(word)) {
                index = i;
                break;
            }
        }
        
        return index;
    }
}
