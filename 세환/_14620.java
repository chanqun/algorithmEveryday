import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int [][] map;
	static boolean[][] visit;
	static int n;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static int result = Integer.MAX_VALUE;
	public static void main (String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int [n][n];
		visit = new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs (0, 0);
		
		System.out.println(result);
		
	}
	
	static void dfs (int count, int sum) {
		
		if (count == 3) {
			result = Math.min(result, sum);
		}
		else {
			for (int i = 1; i < n - 1; i++) {
				for (int j = 1; j < n - 1; j++) {
					if (!visit[i][j] && check(i, j)) {
						visit[i][j] = true;
						int hap = sum(i, j);
						
						dfs (count + 1, sum + hap);
						
						visitClear(i, j);
						visit[i][j] = false;
					}
				}
			}
		}
	}
	
	static boolean check (int x, int y) {
		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (visit[nx][ny]) {
				return false;
			}
		}
		
		return true;
	}
	
	static void visitClear (int x, int y) {
		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			visit[nx][ny] = false;
		}
	}
	
	static int sum (int x, int y) {
		int hap = map[x][y];
		
		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			visit[nx][ny] = true;
			hap += map[nx][ny];
		}
		
		return hap;
	}
}