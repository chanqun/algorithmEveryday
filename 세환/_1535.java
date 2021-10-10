import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] energy = new int[100];
	public static void main (String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> e = new ArrayList<>();
		List<Integer> g = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			e.add(Integer.parseInt(st.nextToken()));
			g.add(Integer.parseInt(st2.nextToken()));
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 99; j >= 0; j--) {
				int index = e.get(i) + j;
				
				if (index < 100) {
					energy[index] = Math.max(energy[index], energy[j] + g.get(i));
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < energy.length; i++) {
			max = Math.max(max, energy[i]);
			
		}
		System.out.println(max);
	}
}