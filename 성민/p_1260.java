package dfs_bfs;

import java.util.*;
import java.io.*;

public class p_1260 {
	
	static int N, M, V;
	
	static boolean [][] E;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		E = new boolean [N+1][N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			E[a][b] = true;
			E[b][a] = true;
		}
		
		Stack<Integer> stack = new Stack<>();
		
		boolean [] visited = new boolean[N+1];
		
		System.out.print(V+" ");
		
		visited[V] = true;
		
		stack.add(V);
		
		while(!stack.isEmpty()) {
			boolean check = false;
			for(int i = 1; i <= N; i++) {
				if(!visited[i]&&E[stack.peek()][i]) {
					System.out.print(i+" ");
					stack.add(i);
					visited[i] = true;
					check = true;
					break;
				}
			}
			if(!check) {
				stack.pop();
			}
		}
		
		System.out.println();
		
		Queue<Integer> queue = new LinkedList<>();
		
		visited = new boolean[N+1];
		
		System.out.print(V+" ");
		
		visited[V] = true;
		
		queue.add(V);
		
		while(!queue.isEmpty()) {
			for(int i = 1; i <= N; i++) {
				if(!visited[i]&&E[queue.peek()][i]) {
					System.out.print(i+" ");
					queue.add(i);
					visited[i] = true;
				}
			}
			queue.poll();
		}

	}

}
