class Solution {
    int[] visit = new int[12];
    int n;
    int answer = 0;
    
    public int solution(int n) {
        this.n = n;
        
        dfs(0);
        
        return answer;
    }
    
    private void dfs(int count) {
        if (count == n) {
            answer++;
            return;
        }
        
        for (int i=0; i<n; i++) {
            visit[count] = i;
            
            if (isPossible(count)) {
                dfs(count + 1);
            }
        }
    }
    
    private boolean isPossible(int col) {
        for (int i = 0; i < col; i++) {
            if (visit[col] == visit[i]) {
                return false;
            } 

            else if (Math.abs(col - i) == Math.abs(visit[col] - visit[i])) {
                return false;
            }
        }

        return true;
    }
}
