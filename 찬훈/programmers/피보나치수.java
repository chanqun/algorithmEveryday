class Solution {
    int divNum = 1234567;
    
    public int solution(int n) {
        int answer = 0;
        
        if (n==0) {
            return 0;
        }
        if (n==1 || n==2) {
            return 1;
        }
        
        int f1 = 1;
        int f2 = 1;
        
        for (int i=3;i<=n;i++) {
            answer = f1 + f2;

            f1 = f2 % divNum;
            f2 = answer % divNum;
        }

        return answer % divNum;
    }
}

