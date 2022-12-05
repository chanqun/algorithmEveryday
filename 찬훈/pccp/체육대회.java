import java.util.*;

class Solution {
    int[] v = new int[10];
    int myMax = 0;
    int sum = 0;

    public int solution(int[][] ability) {
        int answer = 0;

        dfs(ability, 0);

        answer = myMax;

        return answer;
    }

    private void dfs(int[][] ability, int index) {
        if(index == ability[0].length) {
            if(myMax < sum) {
                myMax = sum;
            }
            return;
        }

        for (int i=0; i < ability.length; i++) {
            if (v[i] == 1) {
                continue;
            }

            v[i] = 1;
            sum += ability[i][index];
            dfs(ability, index + 1);
            sum -= ability[i][index];
            v[i] = 0;
        }
    }
}
