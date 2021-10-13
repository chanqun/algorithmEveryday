import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main (String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		int[] b = new int[n];
		
		StringTokenizer strA = new StringTokenizer(br.readLine());
		StringTokenizer strB = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(strA.nextToken());
			b[i] = Integer.parseInt(strB.nextToken());
		}
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		int answer = 0;
		for (int i = 0; i < n; i ++) {
			answer += a[i] * b[n - 1 - i];
		}
		
		System.out.println(answer);
	}
}