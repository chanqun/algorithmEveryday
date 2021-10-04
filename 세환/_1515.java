import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	public static void main (String [] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String data = br.readLine();
		
		int idx = 0;
		int answer = 0;
		
		for (int i = 1; ; i++) {
			String num = "" + i;
			for(int j = 0; j < num.length(); j++) {
				if (idx == data.length()) continue;
				
				if(data.substring(idx, idx + 1).equals(num.substring(j, j + 1))) {
					idx++;
				}
			}
			
			if (idx == data.length()) {
				answer = i;
				break;
			}
		}
		
		System.out.println(answer);
		
	}
}