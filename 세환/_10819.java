import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int [] arr;
	static boolean [] visit;
	static int[] tArr;
	
	static int n;
	static int answer = 0;
	
	public static void main (String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		tArr = new int[n];
		visit = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		
		permutation(0);
		System.out.println(answer);
	}
	
	static void permutation (int idx) {
		if (idx == n) {
			int sum = 0;
			for (int i = 0; i < n - 1; i++) {
				sum += Math.abs(tArr[i] - tArr[i + 1]);
			}
			answer = Math.max(answer, sum);
			return;
		}
		
		for (int i = 0; i < n; i++) { 
			if(visit[i]) continue;
			
			visit[i] = true;
			tArr[idx] = arr[i];
			permutation(idx + 1);
			visit[i] = false;
		}
	}
}