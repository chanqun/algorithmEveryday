import java.io.*;
import java.util.*;

public class Main {
    static int[] AI = new int[100_001];
    static boolean[] visit = new boolean[100_001];
    static int n;
    
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= n; i++) {
            AI[i] = Integer.parseInt(st.nextToken());
        }
        
        visit[s] = true;
        check(s);
        
        int answer = 0;
        for (int i = 0; i < visit.length; i++) {
            if (visit[i]) answer++;
        }
        
        System.out.println(answer);
    }
    
    static void check (int s) {
        if (s > n || s < 1) return;
        
        if (s + AI[s] <= n && !visit[s + AI[s]]) {
            visit[s + AI[s]] = true;
            check(s + AI[s]);
        }
        
        if (s - AI[s] > 0 && !visit[s - AI[s]]) {
            visit[s - AI[s]] = true;
            check(s - AI[s]);
        }
    }
}