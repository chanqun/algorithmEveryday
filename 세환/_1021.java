import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main (String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int count = 0;
		
		LinkedList<Integer> d = new LinkedList<>();
		
		for (int i = 1; i <= n; i++) {
			d.add(i);
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			int target_idx = d.indexOf(num);
			int half_idx;
			
			if (d.size() % 2 == 0) {
				half_idx = d.size() / 2 - 1;
			} else {
				half_idx = d.size() / 2 ;
			}
			
			if (target_idx <= half_idx) {
				for (int j = 0; j < target_idx; j++) {
					int check = d.pollFirst();
					d.offerLast(check);
					count++;
				}
			} else {
				for (int j = 0; j <d.size() - target_idx; j++) {
					int check = d.pollLast();
					d.offerFirst(check);
					count++;
				}
			}
			
			d.pollFirst();
		}
		System.out.println(count);
	}
}