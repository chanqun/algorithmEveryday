package graph;

import java.util.*;

class Node{
	int num;
	int dis;
	public Node(int num, int dis) {
		this.num = num;
		this.dis = dis;
	}
}

public class p_49189 {
	
	public static int solution(int n, int [][] edge) {
	    int answer = 0;

		boolean [][] e = new boolean [n+1][n+1];

		for(int i = 0; i < edge.length; i++) {
			e[edge[i][0]][edge[i][1]] = true;
			e[edge[i][1]][edge[i][0]] = true;
		}

		int [] d = new int [n+1];

		Queue<Node> queue = new LinkedList<Node>();

		queue.add(new Node(1,0));
		
		while(!queue.isEmpty()) {
			Node curr = queue.poll();
			for(int i = 2; i <= n; i++) {
				if(d[i]==0) {
					if(e[curr.num][i]) {
						queue.add(new Node(i,curr.dis+1));
						d[i] = curr.dis+1;
					}
				}
			}
		}
		
		Arrays.sort(d);
		
		for(int i = n; i > 1; i--) {
			if(d[n]!=d[i]) {
				break;
			}
			answer++;
		}

		return answer;
	}

}
