import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        for (int i=0; i<n; i++) {
            if (!visit[i]) {
                answer++;
                q.add(i);
                visit[i] = true;
            }

            while(!q.isEmpty()) {
                int temp = q.poll();

                for (int j=0; j<n; j++) {
                    if (computers[temp][j] == 1 && !visit[j]) {
                        q.add(j);
                        visit[j] = true;
                    } 
                }
            }
        }

        return answer;
    }
}

