class Solution {
    boolean[] visit;
    int[][] dungeons;
    int answer = 0;

    public int solution(int k, int[][] dungeons) {
        
        visit = new boolean[dungeons.length];
        this.dungeons = dungeons;
        
        dfs(k, 0);
        
        return answer;
    }
    
    private void dfs(int k, int count) {
        for (int i=0; i<dungeons.length; i++) {
            int leastNeed = dungeons[i][0];
            int comsumption = dungeons[i][1];
            
            if (!visit[i] && leastNeed <= k) {
                visit[i] = true;
                
                dfs(k - comsumption, count + 1);
                
                answer = Math.max(answer, count + 1);

                visit[i] = false;
            }
        }
    }
}

