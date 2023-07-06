class Solution {
    boolean[] array;
    
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        array = new boolean[n + 1];
        
        for(int num: section) {
            array[num] = true;
        }
        
        for(int i=1; i<=n; i++) {
            if (array[i]) {
                answer++;
                
                if (i>n) {
                    break;
                }
                i += m - 1;
            }
        }
        
        return answer;
    }
}
