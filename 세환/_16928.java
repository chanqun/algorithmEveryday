import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	private static int N = 0;
	private static int M = 0;
	private static int [] MAP = new int[101];
	private static int [] visit = new int[101];
	private static Queue<Integer> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		q = new LinkedList<>();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			MAP[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken()); 
		}
		
		q.add(1);
		
		while (!q.isEmpty()) {
			int now = q.poll();
			
			for (int i = 1; i <= 6; i++) {
				
				int next = now + i;
				
				// 종료 조건
				if (next > 100) {
					continue;
				}
				
				if (MAP[next] != 0) {
					next = MAP[next];
				}
				
				if (visit[next] < 1) {
					visit[next] = visit[now] + 1;
					q.add(next);
				}
			}
		}
		
		System.out.println(visit[100]);
	}
}
