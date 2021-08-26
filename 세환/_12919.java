import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
	private static String S = "";
	private static String T = "";
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		T = br.readLine();
		
		int result = dfs(S,T);
			
		System.out.println(result);
	}
	
	public static int dfs (String s, String t) {
		if (s.length() == t.length()) {
			if (s.equals(t)) {
				return 1;
			} else {
				return 0;
			}
		}
		
		int resultInt = 0;
		
		if (t.charAt(0) == 'B') {
			String result = new StringBuffer(t).reverse().substring(0, t.length()-1);
			resultInt += dfs(s, result);
		}
		
		if (t.charAt(t.length()-1) == 'A') {
			String result = t.substring(0, t.length()-1);
			resultInt += dfs(s, result);
		}
		
		return resultInt > 0 ? 1 : 0;
	}
}
