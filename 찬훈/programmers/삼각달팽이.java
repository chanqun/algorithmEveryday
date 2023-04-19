class Solution {
    int[][] arr;
    int[] dy = {1, 0, -1};
    int[] dx = {0, 1, -1};
    
    public int[] solution(int n) {
        int[] answer = new int[n * (n+1) / 2];
        int length = n;
        
        arr = new int[length][length];
        
        int count = -1;
        int num = 1;
        int y = -1;
        int x = 0;
        
        while(n-- > 0) {
            int dir = (count+1) % 3;
            
            for (int i=0; i<=n; i++) {
                y = y + dy[dir];
                x = x + dx[dir];    
                arr[y][x] = num++;
            }
            
            count++;
        }
        
        count = 0;
        
        for (int i=0; i<length; i++) {
            for (int j=0; j<length; j++) {
                if (arr[i][j] == 0) {
                    continue;
                }
                
                answer[count++] = arr[i][j];
            }
        }
        
        return answer;
    }
}
