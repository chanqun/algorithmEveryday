import java.util.*;

class Solution {
    boolean[][][] visit;
    boolean[][] board;
    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, 1, 0, -1};

    public int solution(int n, int m, int[][] hole) {
        int answer = Integer.MAX_VALUE;
        visit = new boolean[n][m][2];
        board = new boolean[n][m];
        
        for (int[] ints : hole) {
            board[ints[0] - 1][ints[1] - 1] = true;
        }

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 0, 1));
        visit[0][0][1] = true;
        
        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.y == n - 1 && p.x == m - 1) {
                answer = p.cnt;
                break;
            }
            
            for (int i=0; i<4;i ++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                
                if (ny<0 || nx<0 || ny>=n || nx >=m || visit[ny][nx][p.k] || board[ny][nx]) {
                    continue;
                }
                
                visit[ny][nx][p.k] = true;
                q.add(new Point(ny, nx, p.cnt + 1, p.k));
            }
            
            if (p.k > 0) {
                for (int i=0; i<4;i ++) {
                    int ny = p.y + dy[i] * 2;
                    int nx = p.x + dx[i] * 2;

                    if (ny<0 || nx<0 || ny>=n || nx >=m || visit[ny][nx][p.k] || board[ny][nx]) {
                        continue;
                    }

                    visit[ny][nx][p.k - 1] = true;
                    q.add(new Point(ny, nx, p.cnt + 1, p.k - 1));
                }    
            }
        }
        
        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        
        return answer;
    }
}

class Point {
    int y;
    int x;
    int cnt;
    int k;
    
    public Point(int y, int x, int cnt, int k) {
        this.y = y;
        this.x = x;
        this.cnt = cnt;
        this.k = k;
    }
}

