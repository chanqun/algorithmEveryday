import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] m = new int [65]; 
	
	public static void main (String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = Integer.parseInt(br.readLine());
		
		m[64] = 1;
		for (int i = m.length - 1; i > 0; i--) {
			if (m[i] != 0) {
				int num = i / 2;
				m[num] = 2;
			}
		}
		
		int count = 0;
		for (int i = m.length - 1; i > 0; i--) {
			if (m[i] != 0) {
				if (i <= answer) {
					count++;
					answer -= i;
				}
			}
			
			if (answer == 0) {
				break;
			}
		}
		
		System.out.println(count);
	}
}