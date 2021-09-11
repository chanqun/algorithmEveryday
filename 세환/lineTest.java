// 라인 코테 4번문제

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Main {
	
	private static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		int n = 18;
		int[] answer = new int[n];
		
		for (int i = 0; i < n; i++) {
			answer[i] = i + 1;
		}
		
		dfs(answer);
		
		for (int  i = 0; i < n; i++) {
			answer[i] = list.get(i);
		}
		
		for(int i :answer) {
			System.out.print(i + " ");
		}
	}
	
	public static void dfs (int[] answer) {
		if (answer.length == 3) {
			for (int i = 0; i < answer.length; i++) {
				list.add(answer[i]);
			}
			return;
		}
		
		int p = 0;
		for (int i = 2; i <answer.length; i++) {
			if (answer.length % i == 0) {
				p = i;
				break;
			}
		}
		
		int mid = answer.length / p;
		int [][] arr = new int[p][mid];
		
		for (int i = 0; i < answer.length; i++) {
			int idx = i / p;
			arr[i % p][idx] = answer[i];
		}
		
		for (int i = 0; i < p; i++) {
			dfs(arr[i]);
		}
		
	}
}