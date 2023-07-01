class Solution {
    boolean solution(String s) {
        int pCount = 0;
        int yCount = 0;
        
        for (char c: s.toCharArray()) {
            if (c == 'P' || c == 'p') {
                pCount++;
            } else if (c == 'Y' || c == 'y') {
                yCount++;
            }
        }

        return pCount == yCount;
    }
}

