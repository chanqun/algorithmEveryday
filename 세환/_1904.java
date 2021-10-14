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
		
		int[] dp = new int[1_000_001];
		for (int i = 1; i <= n; i++) {
			if (i == 1) {
				dp[i] = 1;
				continue;
			} else if (i == 2) {
				dp[i] = 2;
				continue;
			}
				dp[i] = ( dp[i - 1] % 15746 ) + ( dp[i - 2] % 15746 );
		}
		
		int answer = dp[n] % 15746 ;
		
		System.out.println(answer);
	}
}