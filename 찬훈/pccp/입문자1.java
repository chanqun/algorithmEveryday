class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int yCount = 0;
        int pCount = 0;

        for (int i=0; i<s.length(); i++) {
            char temp = s.charAt(i);

            if (temp == 'y' || temp == 'Y') {
                yCount++;
            }

            if (temp == 'p' || temp == 'P') {
                pCount++;
            }
        }

        answer = (yCount == pCount);

        return answer;
    }
}
