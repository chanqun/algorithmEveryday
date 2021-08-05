package algorithm.kakao;

import java.util.LinkedList;
import java.util.Queue;

public class Lv2카카오프렌즈컬러링북 {
    public static class Coordinate{
        int x;
        int y;
        Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static int bfs(int[][] picture,int x, int y, int m,int n) {

        Queue<Coordinate> queue = new LinkedList<>();
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int value = picture[x][y];
        queue.add(new Coordinate(x,y));
        int area = 1;
        picture[x][y] = 0;
        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = coordinate.x + dx[i];
                int ny = coordinate.y + dy[i];

                if (0 <= nx && nx < m && 0 <= ny && ny < n) {
                    if (picture[nx][ny] > 0 && picture[nx][ny] == value) {
                        queue.add(new Coordinate(nx, ny));
                        picture[nx][ny] = 0;
                        area++;
                    }
                }
            }
        }
        return area;
    }

    public static int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        int[][] copyPicture = new int[m][n];

        for(int i =0; i < m; i++){
            for(int j = 0; j < n; j++){
                copyPicture[i][j] = picture[i][j];
            }
        }
        for(int i =0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(picture[i][j] > 0){
                    int area = bfs(picture,i,j,m,n);
                    if(answer[1] < area) answer[1] = area;
                    answer[0]++;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){

    }
}
