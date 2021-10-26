import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static boolean[] visit;
    
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visit = new boolean[n];
        String str = br.readLine();
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            boolean check = false;
            if (c == 'P') {
                int min = i - k < 0 ? 0 : i - k;
                int max = i + k >= n ? n - 1 : i + k;
                
                for (int j = min; j < i; j++) {
                    if (!visit[j] && str.charAt(j) == 'H') {
                        visit[j] = true;
                        answer++;
                        check = true;
                        break;
                    }
                }
                
                if (check) continue;
            
                for (int j = i + 1; j <= max; j++) {
                    if (!visit[j] && str.charAt(j) == 'H') {
                        visit[j] = true;
                        answer++;
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}