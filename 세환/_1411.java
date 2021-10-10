import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main (String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		String[] input = new String[n];
		for (int i = 0; i < n; i++) {
			input[i] = br.readLine();
		}
		
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				int swp1[] = new int[27]; 
				int swp2[] = new int[27];
				boolean check = true;
				
				for (int k = 0; k < input[i].length(); k++) {
					int a = input[i].charAt(k) - 'a'+1;
					int b = input[j].charAt(k) - 'a'+1;
					if (swp1[a] == 0 && swp2[b] == 0) {
						swp1[a] = b;
						swp2[b] = a;
					}
					else if (swp1[a] != b) check = false;
				}
				if (check) count++;
			}
		}
		
		System.out.println(count);
	}
}