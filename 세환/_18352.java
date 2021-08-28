import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	private static int N = 0; // 도시 개수
	private static int M = 0; // 도로 개수
	private static int K = 0; // 조건
	private static int X = 0; // 출발도시
	
	private static int[] distince = new int[300001];
	
	private static List<List<Integer>> list = new ArrayList<>();
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
	
		
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
			distince[i] = -1;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			list.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
		}
		
		bfs();
		
		boolean check = false;
		for (int i = 1; i < distince.length; i++) {
			if (distince[i] == K) {
				System.out.println(i);
				check = true;
			}
		}
		
		if (!check) {
			System.out.println("-1");
		}
	}
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(X);
		distince[X] = 0;
		
		while (!q.isEmpty()) {
			int val = q.poll();
			
			for (int i = 0; i < list.get(val).size(); i++) {
				int dis = list.get(val).get(i);
				
				if (distince[dis] == -1) { // 궁금증 : -1 초기화 안시키고 기존 0값으로 진행할 땐 틀리는 이유가 궁금하다.
					distince[dis] = distince[val]+1;
					q.add(dis);
				}
			}
		}
	}
}
