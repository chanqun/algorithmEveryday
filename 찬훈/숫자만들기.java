package mobis;

class Solution {
    private int[] arr = new int[10];

    public int solution(int[][] dice) {
        int answer = 0;

        for (int i = 0; i < dice.length; i++) {
            boolean[] tempArr = new boolean[10];

            for (int j = 0; j < dice[i].length; j++) {
                tempArr[dice[i][j]] = true;
            }

            for (int j = 0; j < 10; j++) {
                if (tempArr[j]) {
                    arr[j]++;
                }
            }
        }

        while (true) {
            answer++;

            if (!canMake(answer)) {
                return answer;
            }
        }
    }

    private boolean canMake(int answer) {
        int[] tempArr = new int[10];
        String nowAnswer = "" + answer;

        for (char c : nowAnswer.toCharArray()) {
            tempArr[c - '0']++;
        }

        for (int i = 0; i < 10; i++) {
            if (arr[i] < tempArr[i]) {
                return false;
            }
        }

        return true;
    }
}