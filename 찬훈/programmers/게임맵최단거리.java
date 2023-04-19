import java.util.*;

class Solution {
    int[][] maps;
    int[][] visit;
    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        this.maps = maps;
        
        int height = maps.length;
        int row = maps[0].length;
        visit = new int[height][row];
        
        Queue<Point> q = new LinkedList<>();
        
        q.add(new Point(0,0));
        visit[0][0] = 1;
        
        while(!q.isEmpty()) {
            var point = q.poll();
            int y = point.y;
            int x = point.x;
            
            for (int i=0; i<4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if (ny < 0 || nx < 0 || ny >= height || nx >= row|| maps[ny][nx] == 0|| visit[ny][nx] != 0) {
                    continue;
                } 
                
                visit[ny][nx] = visit[y][x] + 1;
                q.add(new Point(ny, nx));
            }
        }
        
        answer = visit[height - 1][row - 1];

        if (answer == 0) {
            answer = -1;
        }
        
        return answer;
    }
}

class Point {
    int y;
    int x;
    
    public Point (int y, int x) {
        this.y = y;
        this.x = x;
    }
}

