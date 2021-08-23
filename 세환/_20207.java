import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int [] SIZE = new int[367]; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			for (int j = start; j <= end; j++) {
				SIZE[j]++;
			}
		}
		
		int len = 0;
		int max = 0;
		int result = 0;
		
		for (int i = 1; i < SIZE.length; i++) {
			if (SIZE[i] == 0) {
				result += (len * max);
				len = 0;
				max = 0;
			}
			if (SIZE[i] != 0) {
				max = Math.max(max, SIZE[i]);
				len++;
			}
		}
		
		System.out.println(result);
	}
}
