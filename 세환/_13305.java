import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] city = new int [n];
		int[] edge = new int [n - 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < edge.length; i++) {
			edge[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < city.length; i++) {
			city[i] = Integer.parseInt(st.nextToken());
		}
		
		long total = 0;
		int idx = 0;
		long num = edge[0];
		
		for (int i = 1; i < n - 1; i++) {
			if (city[idx] <= city[i]) {
				num += edge[i];
			} else {
				total += city[idx] * num;
				idx = i;
				num = edge[i];
			}
		}
		total += city[idx] * num;
		
		System.out.println(total);
	}
}

