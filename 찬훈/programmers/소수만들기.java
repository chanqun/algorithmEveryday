import java.util.*;

class Solution {
    int[] nums;
    List<Integer> list = new ArrayList<>();    
    
    public int solution(int[] nums) {
        int answer = 0;
        this.nums = nums;
        
        dfs(0, 0, 0);
        
        for(int num: list) {
            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }
    
    private void dfs(int n, int idx, int sum) {
        if(n==3) {
            list.add(sum);
            return;
        }
        
        for (int i=idx; i<nums.length; i++) {
            dfs(n + 1, i + 1, sum + nums[i]);
        }
    }
    
    private boolean isPrime(int num) {
        for (int i=2; i*i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}

