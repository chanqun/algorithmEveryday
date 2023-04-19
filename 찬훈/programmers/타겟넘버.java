class Solution {
    int[] numbers;
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        
        dfs(0, 0, target);
        
        return answer;
    }
    
    private void dfs(int n, int now, int target) {
        if (n == numbers.length) {
            if (now == target) {
                answer++;
            }
            
            return;
        }

        dfs(n + 1, now + numbers[n], target);
        dfs(n + 1, now - numbers[n], target);
    }
}

