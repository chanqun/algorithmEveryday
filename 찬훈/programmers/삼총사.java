class Solution {
    int[] number;
    boolean[] check;
    int answer = 0;
    public int solution(int[] number) {
        this.number = number;
        check = new boolean[number.length];

        dfs(0, 0);
        
        return answer;
    }
    
    private void dfs(int n, int now) {
        if (n == 3) {
            int sum = 0;
            
            for (int i=0; i<check.length; i++) {
                if(check[i]) {
                    sum += number[i];
                }
            }
            
            if (sum == 0) {
                answer++;
            }
            
            return;
        }
        
        for(int i=now; i<number.length; i++) {
            check[i] = true;
            dfs(n+1, i+1);
            check[i] = false;
        }
    }
}

