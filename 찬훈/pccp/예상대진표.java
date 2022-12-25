class Solution {
    public int solution(int n, int a, int b) {
        int answer = 1;
        int na = Math.min(a,b);
        int nb = Math.max(a,b);
        
        while(!isFight(na, nb)) {
            answer++;

            na = na/2 + na%2;
            nb = nb/2 + nb%2;
        }
        
        return answer;
    }
    
    private boolean isFight(int a, int b) {
        if ((a/2)+1 == (b/2) && a%2==1 && b%2==0) {
            return true;
        }

        return false;
    }
}

