import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N = 0;
	static long[] ARR = new long[36]; 
	
	public static void main(String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		ARR[0] = 1;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < i; j++) {
				ARR[i] += ARR[j] * ARR[i-j-1];
			}
		}
		
		System.out.println(ARR[N]);
	}
}
