class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        
        for(int i=1; i<arr.length; i++) {
            answer = calc(answer, arr[i]);
        }
        
        return answer;
    }
    
    private int calc(int a, int b) {
        int common = 1;
        int minNum = Math.min(a, b);
        
        for (int i=1; i<=minNum; i++) {
            if (a%i==0 && b%i==0) {
                common = i;
            }
        }        
        
        return a * b / common;
    }
}

