class Solution {
    int N, M, y, x;
    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, 1, 0, -1};
    
    public int[] solution(String[] park, String[] routes) {
        N = park.length;
        M = park[0].length();
        
        for (int i=0; i< N; i++) {
            for (int j=0; j<M; j++) {
                char temp = park[i].charAt(j);
                
                if (temp == 'S') {
                    y = i;
                    x = j;
                }
            }
        }

        for (String route : routes) {
            String[] commands = route.split(" ");
            char dir = commands[0].charAt(0);
            String n = commands[1];
            
            move(dir, Integer.parseInt(n), park);
        }
        
        return new int[] {y, x};
    }
    
    private void move(char dir, int n, String[] park) {
        int dirNum = getDirNum(dir);
        int ty = y;
        int tx = x;
        
        for (int i=0; i<n; i++) {
            ty += dy[dirNum];
            tx += dx[dirNum];

            if (ty < 0 || tx < 0 || ty >= N || tx >= M || park[ty].charAt(tx) == 'X') {
                return;
            }
        }
        
        y = ty;
        x = tx;
    }
    
    private int getDirNum(char dir) {
        if (dir == 'E') {
            return 1;
        } else if (dir == 'S') {
            return 2;
        } else if (dir == 'W') {
            return 3;
        } else {
            return 0;
        }
    }
}
