class Solution {
    int[][] arr;
    
    int solution(int[][] land) {
        int answer = 0;
        
        this.arr = new int[land.length][4];
        
        arr[0][0] = land[0][0];
        arr[0][1] = land[0][1];
        arr[0][2] = land[0][2];
        arr[0][3] = land[0][3];
        
        for (int i=1; i<land.length; i++) {
            for (int j=0; j<4; j++) {
                if (j!=0) {
                    arr[i][0] = Math.max(arr[i - 1][j], arr[i][0]);
                }
                
                if (j!=1) {
                    arr[i][1] = Math.max(arr[i - 1][j], arr[i][1]);
                }
                
                if (j!=2) {
                    arr[i][2] = Math.max(arr[i - 1][j], arr[i][2]);
                }
                
                if (j!=3) {
                    arr[i][3] = Math.max(arr[i - 1][j], arr[i][3]);
                }
                
                if (j==3) {
                    arr[i][0] += land[i][0];
                    arr[i][1] += land[i][1];
                    arr[i][2] += land[i][2];
                    arr[i][3] += land[i][3];
                }
            }
        }
        
        for (int j=0; j<4; j++) {
            answer = Math.max(answer, arr[land.length - 1][j]);
        }

        return answer;
    }
}
