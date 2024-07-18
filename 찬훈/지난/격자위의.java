import java.util.*;

class Main {
    private static int N;
    private static int[][] grid;
    private static int[][] dist;
    private static boolean[][] visited;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int[][] chars = new int[5][2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        grid = new int[N][N];

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        for (int i=0; i<5; i++) {
            chars[i][0] = sc.nextInt() - 1;
            chars[i][1] = sc.nextInt() - 1;
        }

        int minTotalDist = Integer.MAX_VALUE;

        for (int firstE = 0; firstE <= 4; firstE += 4) {
            int secondE = 4 - firstE;
            
            int startToE = dijkstra(0, 0, chars[firstE][0], chars[firstE][1]);
            int EtoL = dijkstra(chars[firstE][0], chars[firstE][1], chars[1][0], chars[1][1]);
            int LtoI = dijkstra(chars[1][0], chars[1][1], chars[2][0], chars[2][1]);
            int ItoC = dijkstra(chars[2][0], chars[2][1], chars[3][0], chars[3][1]);
            int CtoE = dijkstra(chars[3][0], chars[3][1], chars[secondE][0], chars[secondE][1]);
            
            if (startToE != -1 && EtoL != -1 && LtoI != -1 && ItoC != -1 && CtoE != -1) {
                int totalDist = startToE + EtoL + LtoI + ItoC + CtoE;
                minTotalDist = Math.min(minTotalDist, totalDist);
            }
        }
        
        System.out.println(minTotalDist == Integer.MAX_VALUE ? -1 : minTotalDist);
    }

    private static int dijkstra(int sr, int sc, int er, int ec) {
        dist = new int[N][N];
        visited = new boolean[N][N];

        for (int i=0; i<N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        pq.offer(new int[] {sr, sc, 0});
        dist[sr][sc] = 0;

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0], c = cur[1];
            
            if (visited[r][c]) {
                continue;
            }
            visited[r][c] = true;

            if (r == er && c == ec) {
                return dist[r][c];
            }

            for (int i=0; i<4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr<0 || nr>=N || nc<0 || nc >= N) {
                    continue;
                }

                int newDist = dist[r][c] + grid[r][c] + grid[nr][nc];

                if (newDist < dist[nr][nc]) {
                    dist[nr][nc] = newDist;
                    pq.offer(new int[] {nr, nc, newDist});
                }
            }
        }

        return - 1;
    }
}
