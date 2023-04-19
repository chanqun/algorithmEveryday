class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int size = money.length;
        
        if (size == 3) {
            for (int i=0; i<3; i++) {
                answer = Math.max(answer, money[i]);
            }
            return answer;
        }
        
        int[] dpIncludeFirst = new int[size];
        int[] dpExcludeFirst = new int[size];
        
        dpIncludeFirst[0] = money[0];
        dpIncludeFirst[1] = Math.max(money[0], money[1]);
        
        dpExcludeFirst[0] = 0;
        dpExcludeFirst[1] = money[1];
        
        for (int i=2; i<size; i++) {
            dpExcludeFirst[i] = Math.max(dpExcludeFirst[i-1], dpExcludeFirst[i-2] + money[i]);
            answer = Math.max(answer, dpExcludeFirst[i]);
            
            if (i == size-1){
                break;   
            }
            
            dpIncludeFirst[i] = Math.max(dpIncludeFirst[i-1], dpIncludeFirst[i-2] + money[i]);
            answer = Math.max(answer, dpIncludeFirst[i]);
        }
        
        return answer;
    }
}
