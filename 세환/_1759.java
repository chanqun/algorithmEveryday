import java.io.*;
import java.util.*;

public class Main {
    static char[] s;
    static boolean[] visit;
    static int len, n;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        len = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        s = new char[n];
        visit = new boolean[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
			s[i] = st.nextToken().charAt(0);
		}
        
        Arrays.sort(s);
        
        combination(0, 0);
    }
    
    static void combination (int start, int count) {
    	if (count == len) {
    		String result = "";
    		int c = 0;
    		for (int i = 0; i < n; i++) {
    			if (visit[i]) {
    				if (!check(String.valueOf(s[i]))) c++;
					result += String.valueOf(s[i]);
    			}
    		}
    		if (check(result) && c >= 2) {
    			System.out.println(result);
    		}
    	}
    	
    	for (int i = start; i < n; i++) {
    		if (!visit[i]) {
    			visit[i] = true;
    			combination (i + 1, count + 1);
    			visit[i] = false;
    		}
    	}
    }
    
    static boolean check (String value) {
    	if (value.contains("a") || value.contains("e") || value.contains("i") || value.contains("o") || value.contains("u")) return true;
    	return false;
    }
}