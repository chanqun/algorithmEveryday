import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int n, m;
	
	static int minDistince = Integer.MAX_VALUE;
	
	static List<chickenPoint> homeArr = new ArrayList<>();
	static List<chickenPoint> chickenArr = new ArrayList<>();
	static Stack<chickenPoint> selectChicken = new Stack<>();
	
	public static void main (String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n + 1][n + 1];
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				
				if (num == 1) {
					homeArr.add(new chickenPoint(i, j));
				} else if (map[i][j] == 2) {
					chickenArr.add(new chickenPoint(i, j));
				}
			}
		}
		
		
		select(0, 0);
		System.out.println(minDistince);
	}
	
	static void select (int start, int depth) {
		if (depth == m) {
			backTraking();
			return;
		}
		
		for (int i = start; i < chickenArr.size(); i++) {
			selectChicken.push(chickenArr.get(i));
			select (start + 1, depth + 1);
			selectChicken.pop();
		}
	}

	static void backTraking() {
		int sum = 0;
		for (chickenPoint home : homeArr) {
			int min = Integer.MAX_VALUE;
			for (chickenPoint chichens : selectChicken) {
				int distince = resultAbs (home, chichens);
				min = Math.min(min, distince);
			}
			sum += min;
			
			if (sum > minDistince) return;
		}
		minDistince = Math.min(minDistince, sum);
	}
	
	static int resultAbs (chickenPoint home, chickenPoint chichens) {
		return Math.abs(home.r - chichens.r) +  Math.abs(home.c - chichens.c);
	}
	
	static class chickenPoint {
		int r;
		int c;
		
		public chickenPoint (int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}