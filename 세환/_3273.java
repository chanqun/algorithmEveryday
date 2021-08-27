import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(br.readLine());
		int arr[] = new int[2000001];
		int nArr[] = new int[n];
		int count = 0;
		
		for (int i = 0; i < n; i++) {
			int idx = Integer.parseInt(st.nextToken());
			nArr[i] = idx;
			arr[idx]++; 
		}
		
		for (int i = 0; i < n; i++) {
			int check = x - nArr[i];
			if (check > 0 && arr[check] == 1) {
				count++;
			}
		}
		
		System.out.println(count/2);
		
	}
}
